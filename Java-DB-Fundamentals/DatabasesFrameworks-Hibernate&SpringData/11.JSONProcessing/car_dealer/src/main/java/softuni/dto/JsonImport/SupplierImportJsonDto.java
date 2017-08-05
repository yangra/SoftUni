package softuni.dto.JsonImport;


import com.google.gson.annotations.Expose;

public class SupplierImportJsonDto {
    @Expose
    private String name;
    @Expose
    private Boolean isImporter;

    public SupplierImportJsonDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getImporter() {
        return isImporter;
    }

    public void setImporter(Boolean importer) {
        isImporter = importer;
    }
}
