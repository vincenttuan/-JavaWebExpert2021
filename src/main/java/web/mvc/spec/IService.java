package web.mvc.spec;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
	// 全部查詢
	public List<T> queryAll();
	// 新增
	public int add(T t);
	// 單筆查詢：根據 id 來取得 T 物件
	public Optional<T> getById(Integer id);
	// 修改
	public int update(T t);
	// 刪除
	public int deleteById(Integer id);
	// 判斷 id 是否存在 ?
	public boolean isIdExists(Integer id);
}
