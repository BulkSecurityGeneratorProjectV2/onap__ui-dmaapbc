/*-
 * ================================================================================
 * DCAE DMaaP Bus Controller Web Application
 * ================================================================================
 * Copyright (C) 2017 AT&T Intellectual Property
 * ================================================================================
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
 * ================================================================================
 */
package org.openecomp.dmaapbc.dbcapp.controller;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openecomp.portalsdk.core.logging.logic.EELFLoggerDelegate;
import org.openecomp.portalsdk.core.util.SystemProperties;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Message Router controller: serves Ajax requests made by Angular scripts on
 * pages that show topics and clients.
 */
@Controller
@RequestMapping("/")
public class MessageRouterController extends DbcappRestrictedBaseController {

	private static EELFLoggerDelegate logger = EELFLoggerDelegate.getLogger(MessageRouterController.class);

	private static final String TOPIC_PATH = "/mr_topic";
	private static final String CLIENT_PATH = "/mr_client";

	public MessageRouterController() {
	}

	/**
	 * Answers a request for one page of message router topics. See
	 * {@link #getItemListForPageWrapper(HttpServletRequest, DmaapDataItem)}
	 * 
	 * @param request
	 * @return Item list for the specified page
	 * @throws ServletException
	 */
	@RequestMapping(value = { TOPIC_PATH }, method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getMRTopicsByPage(HttpServletRequest request) throws ServletException {
		MDC.put(SystemProperties.AUDITLOG_BEGIN_TIMESTAMP, DataBusHomeController.logDateFormat.format(new Date()));
		logger.setRequestBasedDefaultsIntoGlobalLoggingContext(request, DataBusHomeController.APP_NAME);
		String response = getItemListForPageWrapper(request, DmaapDataItem.MR_TOPIC);
		MDC.put(SystemProperties.AUDITLOG_END_TIMESTAMP, DataBusHomeController.logDateFormat.format(new Date()));
		logger.info(EELFLoggerDelegate.auditLogger, request.getMethod() + request.getRequestURI());
		return response;
	}

	/**
	 * Answers a request for one page of message router clients. See
	 * {@link #getItemListForPageWrapper(HttpServletRequest, DmaapDataItem)}
	 * 
	 * @param request
	 * @return Item list for the specified page
	 * @throws ServletException
	 */
	@RequestMapping(value = { CLIENT_PATH }, method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getMRClientsByPage(HttpServletRequest request) throws ServletException {
		MDC.put(SystemProperties.AUDITLOG_BEGIN_TIMESTAMP, DataBusHomeController.logDateFormat.format(new Date()));
		logger.setRequestBasedDefaultsIntoGlobalLoggingContext(request, DataBusHomeController.APP_NAME);
		String response = getItemListForPageWrapper(request, DmaapDataItem.MR_CLIENT);
		MDC.put(SystemProperties.AUDITLOG_END_TIMESTAMP, DataBusHomeController.logDateFormat.format(new Date()));
		logger.info(EELFLoggerDelegate.auditLogger, request.getMethod() + request.getRequestURI());
		return response;
	}

	/**
	 * Adds a topic with the specified information. Expects a JSON block in the
	 * request body - a Topic object.
	 * 
	 * @param request
	 * @return Item list for the specified page
	 * @throws ServletException
	 */
	@RequestMapping(value = { TOPIC_PATH }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String addTopic(HttpServletRequest request) throws ServletException {
		MDC.put(SystemProperties.AUDITLOG_BEGIN_TIMESTAMP, DataBusHomeController.logDateFormat.format(new Date()));
		logger.setRequestBasedDefaultsIntoGlobalLoggingContext(request, DataBusHomeController.APP_NAME);
		String response = addItem(request, DmaapDataItem.MR_TOPIC, HttpServletResponse.SC_CREATED);
		MDC.put(SystemProperties.AUDITLOG_END_TIMESTAMP, DataBusHomeController.logDateFormat.format(new Date()));
		logger.info(EELFLoggerDelegate.auditLogger, request.getMethod() + request.getRequestURI());
		return response;
	}

	/**
	 * Adds a client with the specified information. Expects a JSON block in the
	 * request body - a MR_Client object.
	 * 
	 * @param request
	 * @return Success / failure JSON
	 * @throws ServletException
	 */
	@RequestMapping(value = { CLIENT_PATH }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String addMRClient(HttpServletRequest request) throws ServletException {
		MDC.put(SystemProperties.AUDITLOG_BEGIN_TIMESTAMP, DataBusHomeController.logDateFormat.format(new Date()));
		logger.setRequestBasedDefaultsIntoGlobalLoggingContext(request, DataBusHomeController.APP_NAME);
		String response = addItem(request, DmaapDataItem.MR_CLIENT, HttpServletResponse.SC_CREATED);
		MDC.put(SystemProperties.AUDITLOG_END_TIMESTAMP, DataBusHomeController.logDateFormat.format(new Date()));
		logger.info(EELFLoggerDelegate.auditLogger, request.getMethod() + request.getRequestURI());
		return response;
	}

	/**
	 * Updates a topic with the specified information. Expects a JSON block in
	 * the request body - a Topic object.
	 * 
	 * Writes a JSON object as an HTTP response; on success it has a "status"
	 * and possibly a "data" item; on failure, also has an "error" item.
	 * 
	 * @param id
	 * @param request
	 * @return Success / failure JSON
	 * @throws ServletException
	 */
	@RequestMapping(value = { TOPIC_PATH + "/{id}" }, method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public String updateTopic(@PathVariable("id") long id, HttpServletRequest request) throws ServletException {
		MDC.put(SystemProperties.AUDITLOG_BEGIN_TIMESTAMP, DataBusHomeController.logDateFormat.format(new Date()));
		logger.setRequestBasedDefaultsIntoGlobalLoggingContext(request, DataBusHomeController.APP_NAME);
		String response = updateItem(request, DmaapDataItem.MR_TOPIC, Long.toString(id), null);
		MDC.put(SystemProperties.AUDITLOG_END_TIMESTAMP, DataBusHomeController.logDateFormat.format(new Date()));
		logger.info(EELFLoggerDelegate.auditLogger, request.getMethod() + request.getRequestURI());
		return response;
	}

	/**
	 * Updates a client with the specified information. Expects a JSON block in
	 * the request body - a MR_Client object.
	 * 
	 * Writes a JSON object as an HTTP response; on success it has a "status"
	 * and possibly a "data" item; on failure, also has an "error" item.
	 * 
	 * @param id
	 * 
	 * @param request
	 * @return Success / failure JSON
	 * @throws ServletException
	 */
	@RequestMapping(value = { CLIENT_PATH + "/{id}" }, method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public String updateMRClient(@PathVariable("id") long id, HttpServletRequest request) throws ServletException {
		MDC.put(SystemProperties.AUDITLOG_BEGIN_TIMESTAMP, DataBusHomeController.logDateFormat.format(new Date()));
		logger.setRequestBasedDefaultsIntoGlobalLoggingContext(request, DataBusHomeController.APP_NAME);
		String response = updateItem(request, DmaapDataItem.MR_CLIENT, Long.toString(id), null);
		MDC.put(SystemProperties.AUDITLOG_END_TIMESTAMP, DataBusHomeController.logDateFormat.format(new Date()));
		logger.info(EELFLoggerDelegate.auditLogger, request.getMethod() + request.getRequestURI());
		return response;
	}

	/**
	 * Deletes a topic with the FQTN ID specified as a path parameter.
	 * 
	 * FQTN is a string of dot-separated names. Spring, in its infinite wisdom,
	 * truncates extensions on dotted path parameters; e.g., "foo.json" becomes
	 * "foo". Avoid truncation here with the extra ":.+" incantation at the end.
	 * 
	 * Writes a JSON object as an HTTP response; on success it only has "status"
	 * item; on failure, also has an "error" item.
	 * 
	 * @param id
	 *            Path parameter with object ID
	 * @param request
	 * @return Success / failure JSON
	 * @throws ServletException
	 */
	@RequestMapping(value = { "/mr_topic/{id:.+}" }, method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public String deleteTopic(@PathVariable("id") String id, HttpServletRequest request) throws ServletException {
		MDC.put(SystemProperties.AUDITLOG_BEGIN_TIMESTAMP, DataBusHomeController.logDateFormat.format(new Date()));
		logger.setRequestBasedDefaultsIntoGlobalLoggingContext(request, DataBusHomeController.APP_NAME);
		String response = deleteItem(request, DmaapDataItem.MR_TOPIC, id, 204);
		MDC.put(SystemProperties.AUDITLOG_END_TIMESTAMP, DataBusHomeController.logDateFormat.format(new Date()));
		logger.info(EELFLoggerDelegate.auditLogger, request.getMethod() + request.getRequestURI());
		return response;
	}

	/**
	 * Deletes a client with the mrClientId specified as a path parameter.
	 * 
	 * Writes a JSON object as an HTTP response; on success it only has "status"
	 * item; on failure, also has an "error" item.
	 * 
	 * @param id
	 *            Path parameter with object ID
	 * @param request
	 * @return Success / failure JSON
	 * @throws ServletException
	 */
	@RequestMapping(value = { "/mr_client/{id}" }, method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public String deleteMRClient(@PathVariable("id") long id, HttpServletRequest request) throws ServletException {
		MDC.put(SystemProperties.AUDITLOG_BEGIN_TIMESTAMP, DataBusHomeController.logDateFormat.format(new Date()));
		logger.setRequestBasedDefaultsIntoGlobalLoggingContext(request, DataBusHomeController.APP_NAME);
		String response = deleteItem(request, DmaapDataItem.MR_CLIENT, Long.toString(id), null);
		MDC.put(SystemProperties.AUDITLOG_END_TIMESTAMP, DataBusHomeController.logDateFormat.format(new Date()));
		logger.info(EELFLoggerDelegate.auditLogger, request.getMethod() + request.getRequestURI());
		return response;
	}

}
