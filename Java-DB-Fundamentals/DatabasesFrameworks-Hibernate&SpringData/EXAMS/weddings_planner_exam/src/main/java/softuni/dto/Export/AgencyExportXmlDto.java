package softuni.dto.Export;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Yana on 8/11/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AgencyExportXmlDto {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private BigDecimal profit;
    @XmlElement(name="wedding")
    private List<WeddingExportXmlDto> weddings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public List<WeddingExportXmlDto> getWeddings() {
        return weddings;
    }

    public void setWeddings(List<WeddingExportXmlDto> weddings) {
        this.weddings = weddings;
    }
}
