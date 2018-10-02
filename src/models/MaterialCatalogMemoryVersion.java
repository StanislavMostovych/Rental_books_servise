package models;

import java.util.List;
import java.util.TreeMap;

public class MaterialCatalogMemoryVersion  implements MaterialCatalogInterface {
	
	private TreeMap<String, Material> materialMap;
	
	public MaterialCatalogMemoryVersion() {
		materialMap = new TreeMap<String, Material>();
	}
	
	public void addMaterial(Material newMaterial) {
		materialMap.put(newMaterial.getID(), newMaterial);
	}

	public TreeMap<String, Material> getMaterialMap(){
		return materialMap;
	}
	
public Material findMaterial(String title) throws MaterialNotFoundException{
		
		title = title.trim();
		
		for (Material nextMaterial : materialMap.values()) {
			if(nextMaterial.getTitle().equalsIgnoreCase(title)) {
				return nextMaterial;
			}
		}

		throw new MaterialNotFoundException();
	}

@Override
public void addMaterail(Material newMaterial) {
	// TODO Auto-generated method stub
	
}

@Override
public int getNumberOfMaterials() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public List<Material> findItemsSoundingLike(String title) {
	// TODO Auto-generated method stub
	return null;
}
}
