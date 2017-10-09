package softuni.dto.Export;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Yana on 8/13/2017.
 */
@XmlRootElement(name="branches")
@XmlAccessorType(XmlAccessType.FIELD)
public class BranchesExportXmlDto {
    @XmlElement(name = "branch")
    private List<BranchExportXmlDto> branchExportXmlDtos;

    public List<BranchExportXmlDto> getBranchExportXmlDtos() {
        return branchExportXmlDtos;
    }

    public void setBranchExportXmlDtos(List<BranchExportXmlDto> branchExportXmlDtos) {
        this.branchExportXmlDtos = branchExportXmlDtos;
    }
}
