





实体类

```
@Table(name="sys_user") // 设置对应的表名
@SafeDelete(name="flag",status="1")
@AutoCreate
public class SysUser implements Serializable {
    
    @Id //设置为主键值
    @Column(name="id") //设置数据库中对应的字段名
    private Long userId;

    @Column(name="status") // 设置数据库中对应的字段名
    private boolean status;
    
    @Column(name="user_name")
    private String userName;
    
    @Column(name="create_date")
    private Date createDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}




```



接口

```
public interface CrudRepository<T>  { //CrudTemplate
	int save(T var1) throws Exception;

    int update(T var1, T condi) throws Exception;

    int update(T var1, T condi, String extCond) throws Exception;
    
    int update(T var1, Criteria cri) throws Exception;

    int delete(T var1, T condi) throws Exception;
    
    int delete(T var1, String extCond) throws Exception;

    int[] saveBatch(List<T> var1) throws Exception;

    int[] updateBatch(List<T> var1, T cond) throws Exception;

    int[] updateBatch(List<T> var1, T cond, String condi) throws Exception;

    int[] deleteBatch(List<T> var1, T condi) throws Exception;
    
    int[] deleteBatch(List<T> var1, T condi) throws Exception;

    int[] executeBatchByBean(String var1, List<T> var2) throws Exception;

    int[] executeBatch(String var1, List<Map<String, Object>> var2) throws Exception;

    List<T> queryAll(String var1, Map var2) throws Exception;
	
	T query(String var1, Map var2) throws Exception;
	    
    List<Map<String, Object>> queryAllForList(String var1, Map var2) throws Exception;

    Map<String, Object> queryForMap(String var1, Map var2) throws Exception;
    
   List<Map<String, Object>> execQuery(Stringsql，Map params) throws Exception;
    
   int execUpdate(String sql，Map params) throws Exception;

    PageResult querForPage(String var1, Map var2, int var3, int var4) throws Exception;
}
```

