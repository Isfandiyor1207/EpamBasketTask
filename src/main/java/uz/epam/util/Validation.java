package uz.epam.util;

import org.apache.poi.ss.usermodel.Cell;

public class Validation {

    public Double checkNumericDataTypeToValidation(Cell cell, int rowIndex, int columnIndex) {
        try {
            return cell.getNumericCellValue();
        } catch (IllegalStateException e) {
            System.err.printf("Please check data in %s row and %s column.%n", rowIndex, columnIndex);
            return null;
        }
    }

    public String checkStringDataToValidation(Cell cell, int rowIndex, int columnIndex) {
        try {
            return cell.getStringCellValue();
        } catch (IllegalStateException e) {
            System.err.printf("Please check data in %s row and %s column.%n", rowIndex, columnIndex);
            return null;
        }
    }

}
