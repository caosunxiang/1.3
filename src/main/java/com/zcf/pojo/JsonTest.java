package com.zcf.pojo;

import java.util.List;

public class JsonTest<T> {
private String name;
private List<T> list;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<T> getList() {
	return list;
}
public void setList(List<T> list) {
	this.list = list;
}

}
