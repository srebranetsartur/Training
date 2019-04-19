package entities;

public class Category {
    private long id;
    private String title;
    private String unitMeasure;

    public Category() {

    }

    public Category(String title, String unitMeasure) {
        this.title = title;
        this.unitMeasure = unitMeasure;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }
}
