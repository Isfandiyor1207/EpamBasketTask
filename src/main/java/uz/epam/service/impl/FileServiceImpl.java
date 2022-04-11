package uz.epam.service.impl;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import uz.epam.domain.Ball;
import uz.epam.enums.Colour;
import uz.epam.service.FileService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {

    private final String path = "D:/desktop/leetCode/epam/BallBasket/workbook.xlsx";
    private final XSSFWorkbook workbook;
    private final XSSFSheet spreadsheet;
    private XSSFRow row;

    public FileServiceImpl() {
        this.workbook = new XSSFWorkbook();
        this.spreadsheet = this.workbook.createSheet("Balls");
        this.row = spreadsheet.createRow((short) 0);
    }


    @Override
    public String createFile() {

        boolean createdFile = false;

        File file = new File("workbook.xlsx");
        if (!file.exists()) {
            try {
                createdFile = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (createdFile) {
                createTitleInFile();
                return "File successfully created.";
            } else return "The Titles cannot be written.";
        } else
            return "File is already exists.";
    }

    @Override
    public void writeToFile() {

        System.out.println(createFile());

        BasketServiceImpl basketService = new BasketServiceImpl();

        List<Ball> ballList = basketService.fillTheBasket();

        for (Ball ball : ballList) {
            row = spreadsheet.createRow(ball.getId());
            row.createCell(0).setCellValue(ball.getId());
            row.createCell(1).setCellValue(ball.getRadius());
            row.createCell(2).setCellValue(ball.getWeight());
            row.createCell(3).setCellValue(ball.getColour().toString());
        }

        try {
            FileOutputStream out = new FileOutputStream(path);
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void createTitleInFile() {

        CellStyle cellStyle = giveColorToTitle();

        row.createCell(0).setCellValue("Id");
        row.getCell(0).setCellStyle(cellStyle);
        row.createCell(1).setCellValue("Radius");
        row.getCell(1).setCellStyle(cellStyle);
        row.createCell(2).setCellValue("Weight");
        row.getCell(2).setCellStyle(cellStyle);
        row.createCell(3).setCellValue("Colour");
        row.getCell(3).setCellStyle(cellStyle);
    }

    public CellStyle giveColorToTitle() {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        style.setFont(font);

        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    @Override
    public List<Ball> readFromFile() {

        List<Ball> ballList = new ArrayList<>();

        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook baeuldungWorkBook = new XSSFWorkbook(inputStream);
            for (Sheet sheet : baeuldungWorkBook) {
                int firstRow = sheet.getFirstRowNum();
                int lastRow = sheet.getLastRowNum();
                for (int index = firstRow + 1; index <= lastRow; index++) {
                    Row row = sheet.getRow(index);
                    Ball ball = new Ball();
                    for (int cellIndex = row.getFirstCellNum(); cellIndex < row.getLastCellNum(); cellIndex++) {
                        Cell cell = row.getCell(cellIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                        switch (cell.getColumnIndex()) {
                            case 0 -> ball.setId((int) cell.getNumericCellValue());
                            case 1 -> ball.setRadius((int) cell.getNumericCellValue());
                            case 2 -> ball.setWeight((long) cell.getNumericCellValue());
                            case 3 -> ball.setColour(Colour.valueOf(cell.getStringCellValue()));
                        }
                    }
                    ballList.add(ball);
                }
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ballList;
    }

}
//    @Override
//    public List<Ball> readFromFile() {
//
//        List<Ball> ballList = new ArrayList<>();
//
//        Sheet sheet = workbook.getSheetAt(0);
//
//        int numberOfRows = sheet.getPhysicalNumberOfRows();
//
//        for (int i = 1; i < numberOfRows; i++) {
//            Ball ball = new Ball();
//            Row row = sheet.getRow(i);
//            Iterator<Cell> cellIterator = row.cellIterator();
//
//            int indexOfCell = 0;
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//
//                switch (indexOfCell) {
//                    case 0 -> ball.setId((int) cell.getNumericCellValue());
//                    case 1 -> ball.setRadius((int) cell.getNumericCellValue());
//                    case 2 -> ball.setWeight((long) cell.getNumericCellValue());
//                    case 3 -> ball.setColour(Colour.valueOf(cell.getStringCellValue()));
//                }
//                indexOfCell++;
//            }
//            ballList.add(ball);
//        }
//
//        return ballList;
//    }
