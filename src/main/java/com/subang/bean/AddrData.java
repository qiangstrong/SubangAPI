package com.subang.bean;

import java.io.Serializable;
import java.util.List;

import com.subang.domain.City;
import com.subang.domain.District;
import com.subang.domain.Region;

public class AddrData implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<City> citys;
	private List<District> districts;
	private List<Region> regions;
	private Integer defaultCityid;
	private String defaultCityname;
	private Integer defaultDistrictid;
	private String defaultDistrictname;
	private Integer defaultRegionid;
	private String defaultRegionname;
	private String detail;

	public AddrData() {
	}

	public AddrData(List<City> citys, List<District> districts, List<Region> regions,
			Integer defaultCityid, String defaultCityname, Integer defaultDistrictid,
			String defaultDistrictname, Integer defaultRegionid, String defaultRegionname,
			String detail) {
		super();
		this.citys = citys;
		this.districts = districts;
		this.regions = regions;
		this.defaultCityid = defaultCityid;
		this.defaultCityname = defaultCityname;
		this.defaultDistrictid = defaultDistrictid;
		this.defaultDistrictname = defaultDistrictname;
		this.defaultRegionid = defaultRegionid;
		this.defaultRegionname = defaultRegionname;
		this.detail = detail;
	}

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public Integer getDefaultCityid() {
		return defaultCityid;
	}

	public void setDefaultCityid(Integer defaultCityid) {
		this.defaultCityid = defaultCityid;
	}

	public String getDefaultCityname() {
		return defaultCityname;
	}

	public void setDefaultCityname(String defaultCityname) {
		this.defaultCityname = defaultCityname;
	}

	public Integer getDefaultDistrictid() {
		return defaultDistrictid;
	}

	public void setDefaultDistrictid(Integer defaultDistrictid) {
		this.defaultDistrictid = defaultDistrictid;
	}

	public String getDefaultDistrictname() {
		return defaultDistrictname;
	}

	public void setDefaultDistrictname(String defaultDistrictname) {
		this.defaultDistrictname = defaultDistrictname;
	}

	public Integer getDefaultRegionid() {
		return defaultRegionid;
	}

	public void setDefaultRegionid(Integer defaultRegionid) {
		this.defaultRegionid = defaultRegionid;
	}

	public String getDefaultRegionname() {
		return defaultRegionname;
	}

	public void setDefaultRegionname(String defaultRegionname) {
		this.defaultRegionname = defaultRegionname;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void selectCity(int index) {
		City city = citys.get(index);
		defaultCityid = city.getId();
		defaultCityname = city.getName();
	}

	public void selectDistrict(int index) {
		District district = districts.get(index);
		defaultDistrictid = district.getId();
		defaultDistrictname = district.getName();
	}

	public void selectRegion(int index) {
		Region region = regions.get(index);
		defaultRegionid = region.getId();
		defaultRegionname = region.getName();
	}
}
