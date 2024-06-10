package querysql;

public class CategorySQL {
    public static final String FIND_ALL = "select * from category;";
    public static final String FIND_CATEGORY_BY_ID = "select * from category where id =?;";
    public static final String DELETE_CATEGORY = "delete from category where id =?;";
    public static final String UPDATE_CATEGORY = "update category set nameCategory = ? where id = ?;";
    public static final String ADD_CATEGORY = "insert into product(nameCategory) value (?);";
}
