package com.workintech.spring.developer.tax;

public interface Taxable {
    double getSimpleTaxRate();
    double getMiddleTaxRate();
    double getUpperTaxRate();
}
