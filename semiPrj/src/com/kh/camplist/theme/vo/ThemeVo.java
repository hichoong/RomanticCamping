package com.kh.camplist.theme.vo;

public class ThemeVo {
	
	public ThemeVo() {
		
	}
	
	public ThemeVo(String themeCode, String themeName) {
		super();
		this.themeCode = themeCode;
		this.themeName = themeName;
	}

	private String themeCode;
	private String themeName;
	
	public String getThemeCode() {
		return themeCode;
	}

	public void setThemeCode(String themeCode) {
		this.themeCode = themeCode;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	@Override
	public String toString() {
		return "ThemeVo [themeCode=" + themeCode + ", themeName=" + themeName + "]";
	}
	
}
