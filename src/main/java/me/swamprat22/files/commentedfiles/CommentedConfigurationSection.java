package me.swamprat22.files.commentedfiles;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class CommentedConfigurationSection implements ConfigurationSection {
	protected ConfigurationSection config;

	public CommentedConfigurationSection(final ConfigurationSection configuration) {
		config = configuration;
	}

	/**
	 * Gets a defaulted boolean value. These accept values of either "default",
	 * true, or false
	 *
	 * @param path The value key
	 * @return null for "default", otherwise true or false
	 */
	public Boolean getDefaultedBoolean(final String path) {
		if (isBoolean(path))
			return this.getBoolean(path);
		if (isString(path)) {
			final String stringValue = this.getString(path);
			if (stringValue != null && stringValue.equalsIgnoreCase("default")) {
			}
		}

		return null;
	}

	/**
	 * Gets a defaulted boolean value. These accept values of either "default",
	 * true, or false
	 *
	 * @param path The value key
	 * @param def  The value to return if the key is not found
	 * @return null for "default", otherwise true or false
	 */
	public Boolean getDefaultedBoolean(final String path, final Boolean def) {
		final Object value = this.get(path);
		if (value instanceof Boolean)
			return (Boolean) value;
		if (value instanceof String) {
			final String stringValue = (String) value;
			if (stringValue.equalsIgnoreCase("default"))
				return null;
		}

		if (value == null)
			return def;

		return null;
	}

	@Override
	public Set<String> getKeys(final boolean b) {
		return config.getKeys(b);
	}

	@Override
	public Map<String, Object> getValues(final boolean b) {
		return config.getValues(b);
	}

	@Override
	public boolean contains(final String s) {
		return config.contains(s);
	}

	@Override
	public boolean contains(final String s, final boolean b) {
		return config.contains(s, b);
	}

	@Override
	public boolean isSet(final String s) {
		return config.isSet(s);
	}

	@Override
	public String getCurrentPath() {
		return config.getCurrentPath();
	}

	@Override
	public String getName() {
		return config.getName();
	}

	@Override
	public Configuration getRoot() {
		return config.getRoot();
	}

	@Override
	public ConfigurationSection getParent() {
		return config.getParent();
	}

	@Override
	public Object get(final String s) {
		return config.get(s);
	}

	@Override
	public Object get(final String s, final Object o) {
		return config.get(s, o);
	}

	@Override
	public void set(final String s, final Object o) {
		config.set(s, o);
	}

	@Override
	public CommentedConfigurationSection createSection(final String s) {
		return new CommentedConfigurationSection(config.createSection(s));
	}

	@Override
	public CommentedConfigurationSection createSection(final String s, final Map<?, ?> map) {
		return new CommentedConfigurationSection(config.createSection(s, map));
	}

	@Override
	public String getString(final String s) {
		return config.getString(s);
	}

	@Override
	public String getString(final String s, final String s1) {
		return config.getString(s, s1);
	}

	@Override
	public boolean isString(final String s) {
		return config.isString(s);
	}

	@Override
	public int getInt(final String s) {
		return config.getInt(s);
	}

	@Override
	public int getInt(final String s, final int i) {
		return config.getInt(s, i);
	}

	@Override
	public boolean isInt(final String s) {
		return config.isInt(s);
	}

	@Override
	public boolean getBoolean(final String s) {
		return config.getBoolean(s);
	}

	@Override
	public boolean getBoolean(final String s, final boolean b) {
		return config.getBoolean(s, b);
	}

	@Override
	public boolean isBoolean(final String s) {
		return config.isBoolean(s);
	}

	@Override
	public double getDouble(final String s) {
		return config.getDouble(s);
	}

	@Override
	public double getDouble(final String s, final double v) {
		return config.getDouble(s, v);
	}

	@Override
	public boolean isDouble(final String s) {
		return config.isDouble(s);
	}

	@Override
	public long getLong(final String s) {
		return config.getLong(s);
	}

	@Override
	public long getLong(final String s, final long l) {
		return config.getLong(s, l);
	}

	@Override
	public boolean isLong(final String s) {
		return config.isLong(s);
	}

	@Override
	public List<?> getList(final String s) {
		return config.getList(s);
	}

	@Override
	public List<?> getList(final String s, final List<?> list) {
		return config.getList(s, list);
	}

	@Override
	public boolean isList(final String s) {
		return config.isList(s);
	}

	@Override
	public List<String> getStringList(final String s) {
		return config.getStringList(s);
	}

	@Override
	public List<Integer> getIntegerList(final String s) {
		return config.getIntegerList(s);
	}

	@Override
	public List<Boolean> getBooleanList(final String s) {
		return config.getBooleanList(s);
	}

	@Override
	public List<Double> getDoubleList(final String s) {
		return config.getDoubleList(s);
	}

	@Override
	public List<Float> getFloatList(final String s) {
		return config.getFloatList(s);
	}

	@Override
	public List<Long> getLongList(final String s) {
		return config.getLongList(s);
	}

	@Override
	public List<Byte> getByteList(final String s) {
		return config.getByteList(s);
	}

	@Override
	public List<Character> getCharacterList(final String s) {
		return config.getCharacterList(s);
	}

	@Override
	public List<Short> getShortList(final String s) {
		return config.getShortList(s);
	}

	@Override
	public List<Map<?, ?>> getMapList(final String s) {
		return config.getMapList(s);
	}

	@Override
	public <T> T getObject(final String s, final Class<T> aClass) {
		return config.getObject(s, aClass);
	}

	@Override
	public <T> T getObject(final String s, final Class<T> aClass, final T t) {
		return config.getObject(s, aClass, t);
	}

	@Override
	public <T extends ConfigurationSerializable> T getSerializable(final String s, final Class<T> aClass) {
		return config.getSerializable(s, aClass);
	}

	@Override
	public <T extends ConfigurationSerializable> T getSerializable(final String s, final Class<T> aClass, final T t) {
		return config.getSerializable(s, aClass, t);
	}

	@Override
	public Vector getVector(final String s) {
		return config.getVector(s);
	}

	@Override
	public Vector getVector(final String s, final Vector vector) {
		return config.getVector(s, vector);
	}

	@Override
	public boolean isVector(final String s) {
		return config.isVector(s);
	}

	@Override
	public OfflinePlayer getOfflinePlayer(final String s) {
		return config.getOfflinePlayer(s);
	}

	@Override
	public OfflinePlayer getOfflinePlayer(final String s, final OfflinePlayer offlinePlayer) {
		return config.getOfflinePlayer(s, offlinePlayer);
	}

	@Override
	public boolean isOfflinePlayer(final String s) {
		return config.isOfflinePlayer(s);
	}

	@Override
	public ItemStack getItemStack(final String s) {
		return config.getItemStack(s);
	}

	@Override
	public ItemStack getItemStack(final String s, final ItemStack itemStack) {
		return config.getItemStack(s, itemStack);
	}

	@Override
	public boolean isItemStack(final String s) {
		return config.isItemStack(s);
	}

	@Override
	public Color getColor(final String s) {
		return config.getColor(s);
	}

	@Override
	public Color getColor(final String s, final Color color) {
		return config.getColor(s, color);
	}

	@Override
	public boolean isColor(final String s) {
		return config.isColor(s);
	}

	@Override
	public Location getLocation(final String path) {
		return this.getSerializable(path, Location.class);
	}

	@Override
	public Location getLocation(final String path, final Location def) {
		return this.getSerializable(path, Location.class, def);
	}

	@Override
	public boolean isLocation(final String path) {
		return this.getSerializable(path, Location.class) != null;
	}

	@Override
	public CommentedConfigurationSection getConfigurationSection(final String s) {
		final ConfigurationSection section = config.getConfigurationSection(s);
		if (section == null)
			return this.createSection(s);

		return new CommentedConfigurationSection(section);
	}

	@Override
	public boolean isConfigurationSection(final String s) {
		return config.isConfigurationSection(s);
	}

	@Override
	public CommentedConfigurationSection getDefaultSection() {
		return new CommentedConfigurationSection(config.getDefaultSection());
	}

	@Override
	public void addDefault(final String s, final Object o) {
		config.addDefault(s, o);
	}

	@Override
	public List<String> getComments(final String path) {
		return null;
	}

	@Override
	public List<String> getInlineComments(final String path) {
		return null;
	}

	@Override
	public void setComments(final String path, final List<String> comments) {
	}

	@Override
	public void setInlineComments(final String path, final List<String> comments) {
	}

}
