/***************************************************************************
 *                                                                         *
 *                                Chord.java                               *
 *                            -------------------                          *
 *   date                 : 15.08.2004                                     *
 *   copyright            : (C) 2004-2008 Distributed and                  *
 *                              Mobile Systems Group                       *
 *                              Lehrstuhl fuer Praktische Informatik       *
 *                              Universitaet Bamberg                       *
 *                              http://www.uni-bamberg.de/pi/              *
 *   email                : sven.kaffille@uni-bamberg.de                   *
 *                          karsten.loesing@uni-bamberg.de                 *
 *                                                                         *
 *                                                                         *
 ***************************************************************************/

/***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 *   A copy of the license can be found in the license.txt file supplied   *
 *   with this software or at: http://www.gnu.org/copyleft/gpl.html        *
 *                                                                         *
 ***************************************************************************/
package de.uniba.wiai.lspi.chord.service;

import java.io.Serializable;
import java.util.Set;

import de.uniba.wiai.lspi.chord.com.Entry;
import de.uniba.wiai.lspi.chord.data.ID;
import de.uniba.wiai.lspi.chord.data.URL;
import de.uniba.wiai.lspi.chord.service.impl.Entries;
import de.uniba.wiai.lspi.chord.service.impl.RetrievedKey;

/**
 * Provides all methods necessary for a user application. This includes methods
 * for changing connectivity to the network (create, join, leave) as well as for
 * working with content (insert, retrieve, remove).
 * 
 * @author Sven Kaffille, Karsten Loesing
 * @version 1.0.5
 */
public interface Chord {

	/**
	 * Returns the {@link URL} of the local node; is <code>null</code> if no network has been
	 * created or joined.
	 * 
	 * @return {@link URL} of local node.
	 */
	public abstract URL getURL();

	/**
	 * Sets the {@link URL} of the local node to the given value; only available
	 * before creating or joining a network.
	 * 
	 * @param nodeURL
	 *            New {@link URL} of local node.
	 * @throws NullPointerException
	 *             If given URL reference has value <code>null</code>.
	 * @throws IllegalStateException
	 *             If network has already been created or joined.
	 */
	public abstract void setURL(URL nodeURL) throws IllegalStateException;

	/**
	 * Returns the {@link ID} of the local node; is <code>null</code> if no network has been
	 * created or joined.
	 * 
	 * @return {@link ID} of local node.
	 */
	public abstract ID getID();

	/**
	 * Sets the {@link ID} of the local node to the given value; only available
	 * before creating or joining a network.
	 * 
	 * @param nodeID
	 *            New {@link ID} of local node.
	 * @throws NullPointerException
	 *             If given ID reference has value <code>null</code>.
	 * @throws IllegalStateException
	 *             If network has already been created or joined.
	 */
	public abstract void setID(ID nodeID) throws IllegalStateException;

	/**
	 * Creates a new chord network which is not connected to any other node.
	 * Assumes that at least the node URL has been set before by {@link #setURL}.
	 * If no ID has been set before, it is generated by applying a hash function
	 * on the node URL.
	 * 
	 * @throws ServiceException
	 *             Is thrown if creating the local chord node fails, e.g. due to
	 *             unability of creating the endpoint for incoming messages. Is
	 *             also thrown if no URL has been set before.
	 */
	public abstract void create() throws ServiceException;

	/**
	 * Creates a new chord network which is not connected to any other node. The
	 * node ID is generated by applying a hash function on the node {@link URL}.
	 * 
	 * @param localURL
	 *            {@link URL} on which this node accepts incoming requests from
	 *            other chord nodes. The {@link ID} of this node is generated by
	 *            applying a hash function on the node {@link URL}.
	 * @throws NullPointerException
	 *             If <code>localURL</code> is <code>null</code>.
	 * @throws ServiceException
	 *             Is thrown if creating the local chord node fails, e.g. due to
	 *             unability of creating the endpoint for incoming messages.
	 */
	public abstract void create(URL localURL) throws ServiceException;

	/**
	 * Creates a new chord network which is not connected to any other node.
	 * 
	 * @param localURL
	 *            {@link URL} on which this node accepts incoming requests from
	 *            other chord nodes.
	 * @param localID
	 *            {@link ID} of this node.
	 * @throws NullPointerException
	 *             If <code>localURL</code> or <code>localID</code> is
	 *             <code>null</code>.
	 * @throws ServiceException
	 *             Is thrown if creating the local chord node fails, e.g. due to
	 *             unability of creating the endpoint for incoming messages.
	 */
	public abstract void create(URL localURL, ID localID)
			throws ServiceException;

	/**
	 * Joins an existing chord network and announces its presence to the other
	 * nodes. Assumes that at least the node {@link URL} has been set before by
	 * {@link #setURL}. If no {@link ID} has been set before, it is generated
	 * by applying a hash function on the node {@link URL}.
	 * 
	 * @param bootstrapURL
	 *            {@link URL} of one existing node which is used as bootstrap
	 *            node.
	 * @throws NullPointerException
	 *             If <code>bootstrapURL</code> is <code>null</code>.
	 * @throws ServiceException
	 *             If joining fails this exception is thrown. This may be due to
	 *             failure of establishing an endpoint or communication problems
	 *             when contacting the bootstrap node. Is also thrown if no URL
	 *             has been set before.
	 */
	public abstract void join(URL bootstrapURL) throws ServiceException;

	/**
	 * Joins an existing chord network and announces its presence to the other
	 * nodes. The node {@link ID} is generated by applying a hash function on
	 * the node {@link URL}.
	 * 
	 * @param localURL
	 *            The local node is made available under this {@link URL}.
	 * @param bootstrapURL
	 *            {@link URL} of one existing node which is used as bootstrap
	 *            node.
	 * @throws NullPointerException
	 *             If <code>localURL</code> or <code>bootstrapURL</code> is
	 *             <code>null</code>.
	 * @throws ServiceException
	 *             If joining fails this exception is thrown. This may be due to
	 *             failure of establishing an endpoint or communication problems
	 *             when contacting the bootstrap node.
	 */
	public abstract void join(URL localURL, URL bootstrapURL)
			throws ServiceException;

	/**
	 * Joins an existing chord network and announces its presence to the other
	 * nodes.
	 * 
	 * @param localURL
	 *            The local node is made available under this {@link URL}.
	 * @param localID
	 *            {@link ID} of this node.
	 * @param bootstrapURL
	 *            {@link URL} of one existing node which is used as bootstrap
	 *            node.
	 * @throws NullPointerException
	 *             If <code>localURL</code>, <code>localID</code>, or
	 *             <code>bootstrapURL</code> is <code>null</code>.
	 * @throws ServiceException
	 *             If joining fails this exception is thrown. This may be due to
	 *             failure of establishing an endpoint or communication problems
	 *             when contacting the bootstrap node.
	 */
	public abstract void join(URL localURL, ID localID, URL bootstrapURL)
			throws ServiceException;

	/**
	 * Disconnects from the network.
	 * 
	 * @throws ServiceException
	 *             If properly leaving the network fails this exception is
	 *             thrown. The network might have been left as if the local node
	 *             has failed. However, disconnecting from the network is done
	 *             in every case.
	 */
	public abstract void leave() throws ServiceException;

	/**
	 * Inserts a new data object into the network stored under the given key. If
	 * two or more objects with same keys exist, all of them are stored.
	 * 
	 * @param key
	 *            Key, under which the new item is stored.
	 * @param object
	 *            Object for storage in the network.
	 * @throws NullPointerException
	 *             If key or object is <code>null</code>.
	 * @throws ServiceException
	 *             Thrown if insertion failed. The effect of the insertion
	 *             operation is undefined if this exception occurs.
	 */
	public abstract void insert(Key key, Serializable object)
			throws ServiceException;

	/**
	 * Attempts to find all objects with given key.
	 * 
	 * @param key
	 *            Key for which objects shall be retrieved.
	 * @return All objects stored under given key. Set of {@link Serializable}
	 * @throws NullPointerException
	 *             If <code>key</code> is <code>null</code>.
	 * @throws ServiceException
	 *             Is thrown if retrieval failed, e.g. due to a communication
	 *             failure. However, the network is left in a stable state.
	 */
	public abstract Set<Serializable> retrieve(Key key) throws ServiceException;

	/**
	 * Removes the given object stored under given key from the network.
	 * 
	 * @param key
	 *            Key under which the object currently is stored.
	 * @param object
	 *            Object to remove from the network.
	 * @throws NullPointerException
	 *             If key or object is <code>null</code>.
	 * @throws ServiceException
	 *             Thrown if deletion failed. The effect of the delete operation
	 *             is undefined if this exception occurs.
	 */
	public abstract void remove(Key key, Serializable object)
			throws ServiceException;
	
	public abstract void awakeFromCrash();
	
	public abstract void simleave();
	
	public abstract Entries getEntries();
	
	public abstract void insertKeyToThisNode(Entry entryToInsert);

	/**
	 * Method to retrieve value for the key along with keeping track of hop
	 * count values.
	 * 
	 * @param key
	 *            {@link Key}
	 * @return {@link RetrievedKey}
	 * @throws ServiceException
	 */
	public abstract RetrievedKey retrieveWithHopCount(Key key) throws ServiceException;

	/**
	 * Method to return the load count value at node.
	 * 
	 * @return int
	 */
	public abstract int getLoadCount();

	/**
	 * Method to set temporary failure
	 * 
	 * @param tempFailure
	 *            boolean
	 */
	public abstract void setTempFailure(boolean tempFailure);

}