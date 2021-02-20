package com.notsumo.prezelt.prezeltplugin.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class PretzelItem {
	public static ItemStack pretzel;

	public static void init() {
		pretzel = new ItemStack(Material.STICK);
		ItemMeta meta = pretzel.getItemMeta();
		meta.setDisplayName("PRETZEL STICC");
		String[] loreArray = {
				"Now this may look like a regular stick but",
				"don't be fooled! this is actually a pretzel",
				"stick!"
		};
		meta.setLore(new ArrayList<>(Arrays.asList(loreArray)));
		meta.addEnchant(Enchantment.LUCK, 1, false);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
		pretzel.setItemMeta(meta);
	}
}
