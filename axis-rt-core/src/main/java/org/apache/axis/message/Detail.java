/*
 * Copyright 2002-2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.axis.message;

import javax.xml.namespace.QName;
import javax.xml.soap.DetailEntry;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

import java.util.Iterator;

/**
 * Detail Container implementation
 *
 * @author Davanum Srinivas (dims@yahoo.com)
 */
public class Detail extends SOAPFaultElement implements javax.xml.soap.Detail {

    public Detail() {
    }

    /**
     * Creates a new <code>DetailEntry</code> object with the given
     * name and adds it to this <code>Detail</code> object.
     * @param   name a <code>Name</code> object identifying the new <code>DetailEntry</code> object
     * @return DetailEntry.
     * @throws SOAPException  thrown when there is a problem in adding a DetailEntry object to this Detail object.
     */
    public DetailEntry addDetailEntry(Name name) throws SOAPException {
        org.apache.axis.message.DetailEntry entry = new org.apache.axis.message.DetailEntry(name);
        addChildElement(entry);
        return entry;
    }

    /**
     * Gets a list of the detail entries in this <code>Detail</code> object.
     * @return  an <code>Iterator</code> object over the <code>DetailEntry</code>
     *        objects in this <code>Detail</code> object
     */
    public Iterator getDetailEntries() {
        return this.getChildElements();
    }


	@Override
	public SOAPElement addChildElement(QName qname) throws SOAPException {
		throw new UnsupportedOperationException();
	}

	@Override
	public SOAPElement addAttribute(QName qname, String value) throws SOAPException {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getAttributeValue(QName qname) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator getAllAttributesAsQNames() {
		throw new UnsupportedOperationException();
	}

	@Override
	public QName createQName(String localName, String prefix) throws SOAPException {
		throw new UnsupportedOperationException();
	}

	@Override
	public QName getElementQName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public SOAPElement setElementQName(QName newName) throws SOAPException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAttribute(QName qname) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getBaseURI() {
		throw new UnsupportedOperationException();
	}

	@Override
	public short compareDocumentPosition(Node other) throws DOMException {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getTextContent() throws DOMException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setTextContent(String textContent) throws DOMException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isSameNode(Node other) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String lookupPrefix(String namespaceURI) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isDefaultNamespace(String namespaceURI) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String lookupNamespaceURI(String prefix) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEqualNode(Node arg) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getFeature(String feature, String version) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object setUserData(String key, Object data, UserDataHandler handler) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getUserData(String key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public TypeInfo getSchemaTypeInfo() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIdAttribute(String name, boolean isId) throws DOMException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) throws DOMException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
		throw new UnsupportedOperationException();
	}

	@Override
	public DetailEntry addDetailEntry(QName qname) throws SOAPException {
		throw new UnsupportedOperationException();
	}
}
