// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.core.client.traits;

import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.http.policy.RetryOptions;

/**
 * An {@link com.azure.core.client.traits Azure SDK for Java trait} providing a consistent interface for configuration
 * of HTTP-specific settings. Refer to the Azure SDK for Java
 * <a href="https://docs.microsoft.com/azure/developer/java/sdk/http-client-pipeline">HTTP clients and pipelines</a>
 * documentation for more details on proper usage and configuration of the Azure SDK for Java HTTP clients.
 *
 * @param <T> The concrete type that implements the trait. This is required so that fluent operations can continue
 *           to return the concrete type, rather than the trait type.
 * @see com.azure.core.client.traits
 * @see HttpClient
 * @see HttpPipeline
 * @see HttpPipelinePolicy
 * @see RetryOptions
 * @see HttpLogOptions
 */
public interface HttpTrait<T extends HttpTrait<T>> {
    /**
     * Sets the {@link HttpClient} to use for sending and receiving requests to and from the service.
     *
     * @param httpClient The {@link HttpClient} to use for requests.
     * @return Returns the same concrete type with the appropriate properties updated, to allow for fluent chaining of
     *      operations.
     */
    T httpClient(HttpClient httpClient);

    /**
     * Sets the {@link HttpPipeline} to use for the service client.
     *
     * @param pipeline {@link HttpPipeline} to use for sending service requests and receiving responses.
     * @return Returns the same concrete type with the appropriate properties updated, to allow for fluent chaining of
     *      operations.
     */
    T pipeline(HttpPipeline pipeline);

    /**
     * Adds a {@link HttpPipelinePolicy pipeline policy} to apply on each request sent.
     *
     * @param pipelinePolicy A {@link HttpPipelinePolicy pipeline policy}.
     * @return Returns the same concrete type with the appropriate properties updated, to allow for fluent chaining of
     *      operations.
     */
    T addPolicy(HttpPipelinePolicy pipelinePolicy);

    /**
     * Sets the {@link RetryOptions} for all the requests made through the client.
     *
     * @param retryOptions The {@link RetryOptions} to use for all the requests made through the client.
     * @return Returns the same concrete type with the appropriate properties updated, to allow for fluent chaining of
     *      operations.
     */
    T retryOptions(RetryOptions retryOptions);

    /**
     * Sets the {@link HttpLogOptions logging configuration} to use when sending and receiving requests to and from
     * the service. If a {@code logLevel} is not provided, default value of {@link HttpLogDetailLevel#NONE} is set.
     *
     * @param logOptions The {@link HttpLogOptions logging configuration} to use when sending and receiving requests to
     * and from the service.
     * @return Returns the same concrete type with the appropriate properties updated, to allow for fluent chaining of
     *      operations.
     */
    T httpLogOptions(HttpLogOptions logOptions);
}