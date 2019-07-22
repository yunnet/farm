package com.farm.api.vo.search;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: IndexObject.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 11:21:19 <br />
 * 最后修改: 2018-09-04 11:21:19 <br />
 * 修改历史: <br />
 */
public class IndexObject implements Comparable<IndexObject>{
	private Long id;

	private String title;

	private String keywords;

	private String descripton;

	private String postDate;
	
	private String url;

	/*相似度*/
	private float score;
	
	/**
	 * 构造函数
	 */
	public IndexObject() {
		super();
	}

	/**
	 * 构造函数
	 * @param _id
	 * @param _keywords
	 * @param _descripton
	 * @param _postDate
	 * @param _score
	 */
	public IndexObject(Long _id, String _keywords, String _descripton, String _postDate, float _score) {
		super();
		this.id = _id;
		this.keywords = _keywords;
		this.score = _score;
		this.descripton=_descripton;
		this.postDate=_postDate;
	}
	
	@Override
	public int compareTo(IndexObject o) {
		if(this.score < o.getScore()){
			return 1;
		}else if(this.score > o.getScore()){
			return -1;
		}
		return 0;
	}

	/**
	 * 获取 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置 
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置 
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取 
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * 设置 
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * 获取 
	 * @return the descripton
	 */
	public String getDescripton() {
		return descripton;
	}

	/**
	 * 设置 
	 * @param descripton the descripton to set
	 */
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}

	/**
	 * 获取 
	 * @return the postDate
	 */
	public String getPostDate() {
		return postDate;
	}

	/**
	 * 设置 
	 * @param postDate the postDate to set
	 */
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	/**
	 * 获取 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置 
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取 
	 * @return the score
	 */
	public float getScore() {
		return score;
	}

	/**
	 * 设置 
	 * @param score the score to set
	 */
	public void setScore(float score) {
		this.score = score;
	}
}