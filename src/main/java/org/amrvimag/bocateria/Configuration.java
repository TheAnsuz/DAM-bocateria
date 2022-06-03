package org.amrvimag.bocateria;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public class Configuration {

    private static final Map<String, String> values = new HashMap<>();
    private static final List<ConfigurationListener> listeners = new ArrayList<>();

    public static final String FILE = "config.dat";
    public static final char SEPARATOR = '=';

    /**
     * This method will simply run at the start of the program, right after the
     * main class is processed and will add a hook to save the data to a file
     * whenever the application stops.
     */
    static {
        Configuration.reload();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                Configuration.save();
            }

        });
    }

    /**
     * Checks if the configuration file exists and can be read.
     *
     * @return true if the configuration file exists, false otherwise
     */
    public static boolean exists() {
        return new File(FILE).canRead();
    }

    /**
     * Sets a default configuration so if the key does not exist it will hold
     * the given value and will also trigger the ConfigurationListeners, however
     * if the configuration already contains a value for the given key it will
     * simply do nothing.
     *
     * @param key the key of the configuration
     * @param value the value of the configuration
     */
    public static void setDefault(String key, String value) {
        if (Configuration.hasConfig(key))
            return;
        setConfig(key, value);
    }

    /**
     * Reads the data from the configuration file
     */
    public static void reload() {
        String[] data = ResourceIO.storedArray(FILE);

        for (String line : data)
            parseData(line);
    }

    /**
     * Checks if the previously read data contains the given configuration key.
     *
     * @param key configuration key to be check
     * @return true if the loaded data contains a value for the key, false
     * otherwise
     */
    public static boolean hasConfig(String key) {
        return Configuration.getConfig(key.trim()).length() > 0;
    }

    /**
     * Gets the value of the given configuration key, will return an empty
     * string if no value is found.
     *
     * @param key configuration key to be check
     * @return the value of that configuration key or an empty string if no
     * value is found
     */
    public static String getConfig(String key) {
        final String value = values.get(key.trim());
        return value == null ? "" : value;
    }

    /**
     * Gets the value of the given configuration key, if no key is found, it
     * will set the default value for that key and also return it.
     *
     * @param key configuration key to be check
     * @param defaultValue value that will be set and returned if no
     * configuration is found
     * @return the value of that configuration or the defaultValue
     */
    public static String getDefaultConfig(String key, String defaultValue) {
        setDefault(key, defaultValue);
        return getConfig(key);
    }

    /**
     * Replaces the value of given key with any value, this will trigger all
     * {@code ConfigurationListener}, however this will only occur when the
     * value is changed, so if the replacement value is the same as the previous
     * one the configuration will not change.
     *
     * @param key the configuration key
     * @param value the value to be replaced with
     * @return true if the configuration was set, false otherwise
     */
    public static boolean setConfig(String key, String value) {
        key = key.trim();
        final String old = getConfig(key);
        value = value.trim();

        if (old.equals(value))
            return false;

        for (ConfigurationListener listener : listeners) {
            listener.onChange(key, old, value);
        }

        values.put(key, value);
        return true;
    }

    /**
     * Performs the given action for each entry in this map until all entries
     * have been processed or the action throws an exception.Unless otherwise
     * specified by the implementing class, actions are performed in the order
     * of entry set iteration (if an iteration order is specified.) Exceptions
     * thrown by the action are relayed to the caller.
     *
     * @implSpec The default implementation is equivalent to, for this
     * {@code map}:      <pre> {@code
     * for (Map.Entry<K, V> entry : map.entrySet())
     *     action.accept(entry.getKey(), entry.getValue());
     * }</pre>
     *
     * The default implementation makes no guarantees about synchronization or
     * atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param action The action to be performed for each entry
     * @throws NullPointerException if the specified action is null
     * @since 1.8
     */
    public static void forEach(BiConsumer<? super String, ? super String> action) {
        values.forEach(action);
    }

    /**
     * Returns a {@link Set} view of the mappings contained in this map. The set
     * is backed by the map, so changes to the map are reflected in the set, and
     * vice-versa. If the map is modified while an iteration over the set is in
     * progress (except through the iterator's own {@code remove} operation, or
     * through the {@code setValue} operation on a map entry returned by the
     * iterator) the results of the iteration are undefined. The set supports
     * element removal, which removes the corresponding mapping from the map,
     * via the {@code Iterator.remove}, {@code Set.remove}, {@code removeAll},
     * {@code retainAll} and {@code clear} operations. It does not support the
     * {@code add} or {@code addAll} operations.
     *
     * @return a set view of the mappings contained in this map
     */
    public static Set<Entry<String, String>> entrySet() {
        return values.entrySet();
    }

    /**
     * Adds a listener to the configuration so it will be notified of any
     * changes in the configuration.
     *
     * @param listener the ConfigurationListener to be added
     */
    public static void addListener(ConfigurationListener listener) {
        listeners.add(listener);
    }

    /**
     * Removes a listener from the configuration so it will no longer recive
     * notifications when any value is changed.
     *
     * @param listener the ConfigurationListener to be removed
     */
    public static void removeListener(ConfigurationListener listener) {
        listeners.remove(listener);
    }

    /**
     * Checks if the configuration will notify the given listener about any
     * changes.
     *
     * @param listener the ConfigurationListener to be check
     * @return true if the configuration will notify the listener, false
     * otherwise
     */
    public static boolean hasListener(ConfigurationListener listener) {
        return listeners.contains(listener);
    }

    /**
     * Performs the given action for each element of the {@code Iterable} until
     * all elements have been processed or the action throws an exception.
     * Actions are performed in the order of iteration, if that order is
     * specified. Exceptions thrown by the action are relayed to the caller.
     * <p>
     * The behavior of this method is unspecified if the action performs
     * side-effects that modify the underlying source of elements, unless an
     * overriding class has specified a concurrent modification policy.
     *
     * @implSpec
     * <p>
     * The default implementation behaves as if:      <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @since 1.8
     */
    public static void forEach(Consumer<? super ConfigurationListener> action) {
        listeners.forEach(action);
    }

    /**
     * Gets the list containing every ConfigurationListener the configuration is
     * notifing.
     *
     * @return the list of ConfigurationListeners
     */
    public static List<ConfigurationListener> getListeners() {
        return listeners;
    }

    /**
     * Saves the stored configuration to a file and returns the result of the
     * operation, will also send any error messages that occur even if the
     * program continues working normally.
     *
     * @return true if the configuration was saved succesfully.
     */
    public static boolean save() {
        if (values.isEmpty())
            return false;

        String[] data = new String[values.size()];
        int index = 0;
        for (Entry<String, String> entry : values.entrySet()) {
            data[index++] = entry.getKey() + " " + SEPARATOR + " " + entry
                    .getValue();
        }

        return ResourceIO.saveArray(FILE, data);
    }

    private static void parseData(String line) {
        final int index = line.indexOf(SEPARATOR);

        if (index >= 0) {
            values.put(
                    line.substring(0, index).trim(),
                    line.length() > index + 1 ? (line.substring(index + 1))
                    .trim() : ""
            );
        }
    }

    /**
     * A functional interface that will be used as a notifier for any changes on
     * the configuration.
     */
    public static interface ConfigurationListener {

        /**
         * Triggered when any changes are made to the configuration this event
         * will allow different classes to directly run code whenever the
         * aplication's configuration has suffered any changes.
         *
         * @param key the key of the configuration that has been altered.
         * @param oldValue the old value that the configuration held, will
         * contain an empty string if there was no previous value for the
         * changed key
         * @param newValue the new value that will be set (the configuration
         * will not contain this value during the processing of this event as
         * this triggers before the actual modification)
         */
        void onChange(String key, String oldValue, String newValue);

    }

}
