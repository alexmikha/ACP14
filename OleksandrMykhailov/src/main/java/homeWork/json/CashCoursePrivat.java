package homeWork.json;

import java.math.BigDecimal;

/**
 * Created by mi on 16.09.2016.
 */
public class CashCoursePrivat {

    private String ccy;
    private String base_ccy;
    private BigDecimal buy;
    private BigDecimal sale;

    public CashCoursePrivat() {
    }

    public CashCoursePrivat(String ccy, String base_ccy, BigDecimal buy, BigDecimal sale) {
        this.ccy = ccy;
        this.base_ccy = base_ccy;
        this.buy = buy;
        this.sale = sale;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getBase_ccy() {
        return base_ccy;
    }

    public void setBase_ccy(String base_ccy) {
        this.base_ccy = base_ccy;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getSale() {
        return sale;
    }

    public void setSale(BigDecimal sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "CashCoursePrivatbank{" +
                "ccy='" + ccy + '\'' +
                ", base_ccy='" + base_ccy + '\'' +
                ", buy=" + buy +
                ", sale=" + sale +
                '}';
    }
}
