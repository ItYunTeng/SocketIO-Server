/**
 * Copyright (C) 2011 K2C @ Patrick Marques <patrickfmarques@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * Except as contained in this notice, the name(s) of the above copyright holders
 * shall not be used in advertising or otherwise to promote the sale, use or other
 * dealings in this Software without prior written authorization.
 */
package eu.k2c.socket.io.server.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Event handling implementation which only supports one handler per event.
 * 
 * @author "Patrick F. Marques <patrick.marques@k2c.eu>"
 */
public class SocketIOSessionEventRegisterImpl implements SocketIOSessionEventRegister {
	final Map<String, SocketIOEventHandler> eventHandlers = new HashMap<String, SocketIOEventHandler>();

	@Override
	public void registerEventListeners(final String eventName, final SocketIOEventHandler handler) {
		eventHandlers.put(eventName, handler);
	}

	@Override
	public void unRegisterEventListeners(final String eventName) {
		eventHandlers.remove(eventName);
	}

	@Override
	public void removeEventListeners() {
		eventHandlers.clear();
	}

	public SocketIOEventHandler getHandler(final String eventName) {
		return eventHandlers.get(eventName);
	}

}