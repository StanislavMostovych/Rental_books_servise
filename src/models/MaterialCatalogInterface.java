package models;

import java.util.List;
import java.util.Map;


public interface MaterialCatalogInterface {
	
	public void addMaterail(Material newMaterial);
	public Map<String, Material> getMaterialMap();
	public Material findMaterial(String title) throws MaterialNotFoundException;
	public int getNumberOfMaterials();
	public List<Material> findItemsSoundingLike(String title);
}
