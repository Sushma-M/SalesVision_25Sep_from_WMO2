/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.salesdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.salesdb.Customers;
import com.salesdb.Leads;

/**
 * Service object for domain model class {@link Customers}.
 */
public interface CustomersService {

    /**
     * Creates a new Customers. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Customers if any.
     *
     * @param customers Details of the Customers to be created; value cannot be null.
     * @return The newly created Customers.
     */
    Customers create(@Valid Customers customers);


	/**
     * Returns Customers by given id if exists.
     *
     * @param customersId The id of the Customers to get; value cannot be null.
     * @return Customers associated with the given customersId.
	 * @throws EntityNotFoundException If no Customers is found.
     */
    Customers getById(Integer customersId);

    /**
     * Find and return the Customers by given id if exists, returns null otherwise.
     *
     * @param customersId The id of the Customers to get; value cannot be null.
     * @return Customers associated with the given customersId.
     */
    Customers findById(Integer customersId);

	/**
     * Find and return the list of Customers by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param customersIds The id's of the Customers to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Customers associated with the given customersIds.
     */
    List<Customers> findByMultipleIds(List<Integer> customersIds, boolean orderedReturn);


    /**
     * Updates the details of an existing Customers. It replaces all fields of the existing Customers with the given customers.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Customers if any.
     *
     * @param customers The details of the Customers to be updated; value cannot be null.
     * @return The updated Customers.
     * @throws EntityNotFoundException if no Customers is found with given input.
     */
    Customers update(@Valid Customers customers);

    /**
     * Deletes an existing Customers with the given id.
     *
     * @param customersId The id of the Customers to be deleted; value cannot be null.
     * @return The deleted Customers.
     * @throws EntityNotFoundException if no Customers found with the given id.
     */
    Customers delete(Integer customersId);

    /**
     * Deletes an existing Customers with the given object.
     *
     * @param customers The instance of the Customers to be deleted; value cannot be null.
     */
    void delete(Customers customers);

    /**
     * Find all Customers matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Customers.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Customers> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Customers matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Customers.
     *
     * @see Pageable
     * @see Page
     */
    Page<Customers> findAll(String query, Pageable pageable);

    /**
     * Exports all Customers matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all Customers matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the Customers in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Customers.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);

    /*
     * Returns the associated leadses for given Customers id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Leads instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Leads> findAssociatedLeadses(Integer id, Pageable pageable);

}