package querysql;

public class ProductSQL {
    public static final String FIND_ALL = "select * from product;";
    public static final String FIND_PRODUCT_BY_ID = "select * from product where id =?;";
    public static final String DELETE_PRODUCT = "delete from product where id =?;";
    public static final String UPDATE_PRODUCT = "update product set nameProduct = ? , price = ? , quantity =? , color =?, descriptions = ? , category_id = ? where id = ?;";
    public static final String ADD_PRODUCT = "insert into product(nameProduct, price, quantity, color, descriptions, category_id) value (?,?,?,?,?,?);";
}
