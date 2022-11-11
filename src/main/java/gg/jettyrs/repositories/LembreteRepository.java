package gg.jettyrs.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import gg.jettyrs.models.Lembrete;

public class LembreteRepository {

	private static Map<Long, Lembrete> db = new HashMap<>();
	
	public Lembrete insert(Lembrete l) {
		db.put(l.getId(), l);
		return l;
	}
	
	public Lembrete update(Lembrete l) {
		db.put(l.getId(), l);
		return l;
	}
	
	public void delete(long id) {
		db.remove(id);
	}
	
	public Lembrete getbyId(long id) {
		return db.get(id);
	}
	
	public List<Lembrete> getAll(){
		return db.values().stream().collect(Collectors.toList());
	}
	
	public boolean exists(long id) {
		return db.containsKey(id);
	}
	
}
