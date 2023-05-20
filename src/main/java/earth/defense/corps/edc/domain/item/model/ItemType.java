package earth.defense.corps.edc.domain.item.model;

public enum ItemType {
    ARMOR("1"),
    GLOVES("2"),
    HELMET("3"),
    SHIELD("4"),
    SHOES("5"),
    WEAPON("6");

    final String type;

    ItemType(String type) {
        this.type = type;
    }
}
