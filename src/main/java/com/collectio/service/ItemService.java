package com.collectio.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collectio.model.Category;
import com.collectio.model.HandMade;
import com.collectio.model.Item;
import com.collectio.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	SessionFactory sessionFactory;

	private final static Logger LOG = LoggerFactory.getLogger(ItemService.class);

	private final ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public String createItem() {
		System.out.println("Start: createItem");
		try {
			Random random = new Random();
			int count = random.nextInt();
			Category category = new Category();
			category.setName("Category" + count);

			Item item = new Item();
			item.setItemName("Item" + count);
			item.setIsHandMade(HandMade.TRUE);
			item.setCategory(category);

			Item item2 = new Item();
			item2.setItemName("Item" + count++);
			item2.setIsHandMade(HandMade.FALSE);
			item2.setCategory(category);

			Set<Item> items = new HashSet<>();
			items.add(item);
			items.add(item2);

			category.setItems(items);

			Session session = sessionFactory.openSession();
			session.save(item);
			session.save(item2);
			System.out.println("End: createItem");
			return "Created.";
		} catch (Exception xcp) {
			return "Failed to create.";
		}
	}

	@Transactional(readOnly = true)
	public Item findByItemName(String title) {
		Item result = itemRepository.findByItemName(title);
		return result;
	}

	@Transactional(readOnly = true)
	public Collection<Item> findByItemNameLike(String title) {
		Collection<Item> result = itemRepository.findByItemNameLike(title);
		return result;
	}
}
