package com.collectio.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collectio.model.Item;
import com.collectio.service.ItemService;

@RestController
@RequestMapping("/")
public class ItemController {
	private final ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@GetMapping("item")
	public Item findByItemName(@RequestParam String itemName) {
		return itemService.findByItemName(itemName);
	}

	@GetMapping("items")
	public Collection<Item> findByItemNameLike(@RequestParam String itemName) {
		return itemService.findByItemNameLike(itemName);
	}

	@PostMapping("create")
	public String createItem() {
		return itemService.createItem();
	}
}
