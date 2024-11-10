package com.entity;
import com.util.VeDate;
public class Article {
	private String articleid = "A"+VeDate.getStringId();//生成主键编号
	private String title;//标题
	private String image;//图片
	private String contents;//内容
	private String addtime;//发布日期
	private String hits;//点击数
	public String getArticleid() { return articleid; }
	public void setArticleid(String articleid) { this.articleid = articleid; }
	public String getTitle() { return this.title; }
	public void setTitle(String title) { this.title = title; }
	public String getImage() { return this.image; }
	public void setImage(String image) { this.image = image; }
	public String getContents() { return this.contents; }
	public void setContents(String contents) { this.contents = contents; }
	public String getAddtime() { return this.addtime; }
	public void setAddtime(String addtime) { this.addtime = addtime; }
	public String getHits() { return this.hits; }
	public void setHits(String hits) { this.hits = hits; }

// 重载方法 生成JSON类型字符串 
@Override
public String toString() {
return "Article [articleid="+this.articleid+", title="+this.title+", image="+this.image+", contents="+this.contents+", addtime="+this.addtime+", hits="+this.hits+"]";
}



}




/**
* 
*/
