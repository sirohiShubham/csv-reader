package com.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CsvReaderDto {
    @CsvBindByName(column = "Region")
    private String region;

    @CsvBindByName(column = "Country")
    private String country;

    @CsvBindByName(column = "Item Type")
    private String itemType;

    @CsvBindByName(column = "Sales Channel")
    private String salesChannel;

    @CsvBindByName(column = "Order Priority")
    private String orderPriority;

    @CsvBindByName(column = "Order Date")
    private String orderDate;

    @CsvBindByName(column = "Order ID")
    private Long orderId;

    @CsvBindByName(column = "Ship Date")
    private String shipDate;

    @CsvBindByName(column = "Units Sold")
    private Double unitsSold;

    @CsvBindByName(column = "Unit Price")
    private Double unitPrice;

    @CsvBindByName(column = "Unit Cost")
    private Double unitCost;

    @CsvBindByName(column = "Total Revenue")
    private Double totalRevenue;

    @CsvBindByName(column = "Total Cost")
    private Double totalCost;

    @CsvBindByName(column = "Total Profit")
    private Double totalProfit;
}
