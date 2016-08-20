package framework.worldmodel;

public class DimensionSettings {
    private static int hside;
    private static int vside;
    private static int gridsize = 4;
    private static int cellsize;
    private static int halfgridsize;
    private static int hsidemo;
    private static int vsidemo;
    
    
	static int getHside() {
		return hside;
	}
	public static void setHside(int hside) {
		DimensionSettings.hside = hside;
	}
	public static int getHalfgridsize() {
		return halfgridsize;
	}
	public static void setHalfgridsize(int halfgridsize) {
		DimensionSettings.halfgridsize = halfgridsize;
	}
	public static int getVside() {
		return vside;
	}
	public static void setVside(int vside) {
		DimensionSettings.vside = vside;
	}
	public static int getGridsize() {
		return gridsize;
	}
	public static void setGridsize(int gridsize) {
		DimensionSettings.gridsize = gridsize;
	}
	public static int getCellsize() {
		return cellsize;
	}
	public static void setCellsize(int cellsize) {
		DimensionSettings.cellsize = cellsize;
	}
	public static int getHsidemo() {
		return hsidemo;
	}
	public static void setHsidemo(int hsidemo) {
		DimensionSettings.hsidemo = hsidemo;
	}
	public static int getVsidemo() {
		return vsidemo;
	}
	public static void setVsidemo(int vsidemo) {
		DimensionSettings.vsidemo = vsidemo;
	}
}
