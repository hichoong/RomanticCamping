package com.sjy.buisness.camp.vo;

public class BsCampFacVo {
	
	private String wifi;		//와이파이	
	private String electro;		//전기
	private String hotWater;	//온수
	private String pet;			//애완동물반입
	private String store;		//매점
	private String fwood;		//장작판매
	private String playGround;	//운동장
	private String trail;		//산책로
	private String pool;		//물놀이장
	
	public BsCampFacVo() {}
	
	
	public BsCampFacVo(String wifi, String electro, String hotWater, String pet, String store, String fwood,
			String playGround, String trail, String pool) {
		super();
		this.wifi = wifi;
		this.electro = electro;
		this.hotWater = hotWater;
		this.pet = pet;
		this.store = store;
		this.fwood = fwood;
		this.playGround = playGround;
		this.trail = trail;
		this.pool = pool;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public String getElectro() {
		return electro;
	}

	public void setElectro(String electro) {
		this.electro = electro;
	}

	public String getHotWater() {
		return hotWater;
	}

	public void setHotWater(String hotWater) {
		this.hotWater = hotWater;
	}

	public String getPet() {
		return pet;
	}

	public void setPet(String pet) {
		this.pet = pet;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getFwood() {
		return fwood;
	}

	public void setFwood(String fwood) {
		this.fwood = fwood;
	}

	public String getPlayGround() {
		return playGround;
	}

	public void setPlayGround(String playGround) {
		this.playGround = playGround;
	}

	public String getTrail() {
		return trail;
	}

	public void setTrail(String trail) {
		this.trail = trail;
	}

	public String getPool() {
		return pool;
	}

	public void setPool(String pool) {
		this.pool = pool;
	}

	@Override
	public String toString() {
		return "BsCampFacVo [wifi=" + wifi + ", electro=" + electro + ", hotWater=" + hotWater + ", pet=" + pet
				+ ", store=" + store + ", fwood=" + fwood + ", playGround=" + playGround + ", trail=" + trail
				+ ", pool=" + pool + "]";
	}
	
	
	
}
