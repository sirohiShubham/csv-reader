package com.model;

import com.dto.CsvReaderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.*;


@Getter
@Setter
@Table(name = "sales_records")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SalesRecords extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "region")
    private String region;

    @Column(name = "country")
    private String country;

    @Column(name = "itemType")
    private String itemType;

    @Column(name = "salesChannel")
    private String salesChannel;

    @Column(name = "orderPriority")
    private String orderPriority;

    @Column(name = "orderDate")
    private String orderDate;

    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "shipDate")
    private String shipDate;

    @Column(name = "unitsSold")
    private Double unitsSold;

    @Column(name = "unitPrice")
    private Double unitPrice;

    @Column(name = "unitCost")
    private Double unitCost;

    @Column(name = "totalRevenue")
    private Double totalRevenue;

    @Column(name = "totalCost")
    private Double totalCost;

    @Column(name = "totalProfit")
    private Double totalProfit;

    public static SalesRecords from(CsvReaderDto csvReaderDto) {
        SalesRecords salesRecords = SalesRecords.builder()
                .region(csvReaderDto.getRegion())
                .country(csvReaderDto.getCountry())
                .itemType(csvReaderDto.getItemType())
                .salesChannel(csvReaderDto.getSalesChannel())
                .orderPriority(csvReaderDto.getOrderPriority())
                .orderDate(csvReaderDto.getOrderDate())
                .orderId(csvReaderDto.getOrderId())
                .shipDate(csvReaderDto.getShipDate())
                .unitsSold(csvReaderDto.getUnitsSold())
                .unitPrice(csvReaderDto.getUnitPrice())
                .unitCost(csvReaderDto.getUnitCost())
                .totalRevenue(csvReaderDto.getTotalRevenue())
                .totalCost(csvReaderDto.getTotalCost())
                .totalProfit(csvReaderDto.getTotalProfit())
                .build();
        salesRecords.setCreatedTimestamp(DateTime.now());
        salesRecords.setLastUpdatedTimestamp(DateTime.now());
        return salesRecords;
    }
}
