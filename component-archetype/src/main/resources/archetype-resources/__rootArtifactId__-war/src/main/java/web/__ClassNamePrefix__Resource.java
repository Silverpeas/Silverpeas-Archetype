#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (C) 2000 - 2022 Silverpeas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * As a special exception to the terms and conditions of version 3.0 of
 * the GPL, you may redistribute this Program in connection with Free/Libre
 * Open Source Software ("FLOSS") applications as described in Silverpeas's
 * FLOSS exception.  You should have received a copy of the text describing
 * the FLOSS exception, and it is also available here:
 * "https://www.silverpeas.com/legal/licensing"
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package ${package}.web;

import ${package}.model.${ClassNamePrefix};
import org.silverpeas.core.annotation.WebService;
import org.silverpeas.core.util.SilverpeasList;
import org.silverpeas.core.util.logging.SilverLogger;
import org.silverpeas.core.web.rs.RESTWebService;
import org.silverpeas.core.web.rs.annotation.Authorized;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * A REST-based Web resource representing the ${ClassNamePrefix} contributions. Only authorized
 * users can access these resources.
 * TODO update the code to your context.
 */
@WebService
@Path("${rootArtifactId}/{componentInstanceId}")
@Authorized
public class ${ClassNamePrefix}Resource extends RESTWebService {

  @PathParam("componentInstanceId")
  private String componentInstanceId;

  @Override
  protected String getResourceBasePath() {
    return "${rootArtifactId}";
  }

  @Override
  public String getComponentId() {
    return componentInstanceId;
  }

  /**
   * Gets the JSON representation of a list of ${ClassNamePrefix} contributions managed by the
   * component instance of id <code>componentInstanceId</code>.
   * If it doesn't exist, a 404 HTTP code is returned.
   * @return the JSON representation of a list of ${ClassNamePrefix} resources.
   * @see WebProcess#execute()
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<${ClassNamePrefix}Entity> getAll${ClassNamePrefix}() {
    final List<${ClassNamePrefix}> resources = process(() ->
        ${ClassNamePrefix}.getAllByComponentInstanceId(getComponentId())
    ).execute();
    return asWebEntities(resources);
  }

  /**
   * Gets the JSON representation of a ${ClassNamePrefix} represented by the given identifier.
   * If it doesn't exist, a 404 HTTP code is returned.
   * @param id the identifier of the aimed ${ClassNamePrefix}.
   * @return the JSON representation of the asked ${ClassNamePrefix} instance.
   * @see WebProcess#execute()
   */
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public ${ClassNamePrefix}Entity getById(@PathParam("id") String id) {
    final ${ClassNamePrefix} resource = process(() -> get${ClassNamePrefix}(id)).execute();
    return asWebEntity(resource);
  }

  /**
   * Creates a new ${ClassNamePrefix} from its JSON representation and returns it once created.
   * If the user isn't authenticated, a 401 HTTP code is returned. If the user isn't authorized to
   * create a ${ClassNamePrefix}, a 403 is returned. If a problem occurs when processing the
   * request, a 503 HTTP code is returned.
   * @param entity the entity decoded from the embodied JSON representation of a ${ClassNamePrefix}
   * @return the response of the creation with the JSON representation of the created
   * ${ClassNamePrefix}.
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response create${ClassNamePrefix}(${ClassNamePrefix}Entity entity) {
    ${ClassNamePrefix} new${ClassNamePrefix} = entity.as${ClassNamePrefix}For(getComponentId());
    ${ClassNamePrefix} created${ClassNamePrefix} = process(new${ClassNamePrefix}::save).execute();
    ${ClassNamePrefix}Entity createdEntity = asWebEntity(created${ClassNamePrefix});
    return Response.created(createdEntity.getURI()).entity(createdEntity).build();
  }

  /**
   * Updates the ${ClassNamePrefix} identified by the specified identifier from the JSON
   * representation embodied in the incoming request and returns it once updated. If the
   * ${ClassNamePrefix} entity doesn't match with the targeted one, a 400 HTTP code is returned.
   * If the ${ClassNamePrefix} doesn't exist, a 404 HTTP code is returned. If the user isn't
   * authenticated, a 401 HTTP code is returned. If the user isn't authorized to update the
   * ${ClassNamePrefix}, a 403 is returned. If a problem
   * occurs when processing the request, a 503 HTTP code is returned.
   * @param id the identifier of the ${ClassNamePrefix} to update
   * @param entity the Web entity from which the ${ClassNamePrefix} has to be updated
   * @return the response of the update with the JSON representation of the updated
   * ${ClassNamePrefix}.
   */
  @PUT
  @Path("{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public ${ClassNamePrefix}Entity update${ClassNamePrefix}(@PathParam("id") String id,
        ${ClassNamePrefix}Entity entity) {
    final ${ClassNamePrefix} resource = get${ClassNamePrefix}(id);
    entity.update(resource);
    ${ClassNamePrefix} updated${ClassNamePrefix} = process(resource::save).execute();
    return asWebEntity(updated${ClassNamePrefix});
  }

  /**
   * Deletes the ${ClassNamePrefix} identified by the specified identifier.
   * If the ${ClassNamePrefix} doesn't exist, a 404 HTTP code is returned. If the user isn't
   * authenticated, a 401 HTTP code is returned. If the user isn't authorized to delete the
   * ${ClassNamePrefix}, a 403 is returned. If a problem occurs when processing the request, a
   * 503 HTTP code is returned.
   * @param id the identifier of the ${ClassNamePrefix} to delete
   */
  @DELETE
  @Path("{id}")
  public void delete${ClassNamePrefix}(@PathParam("id") String id) {
    final ${ClassNamePrefix} resource = get${ClassNamePrefix}(id);
    process(() -> {
      resource.delete();
      return null;
    }).execute();
  }

  private ${ClassNamePrefix} get${ClassNamePrefix}(final String id) {
    final ${ClassNamePrefix} resource = ${ClassNamePrefix}.getById(id);
    if (resource == null || !resource.getComponentInstanceId().equals(getComponentId())) {
      SilverLogger.getLogger(this).error("Unknown ${ClassNamePrefix} at {0}", getUri().getPath());
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
    return resource;
  }

  private ${ClassNamePrefix}Entity asWebEntity(final ${ClassNamePrefix} resource) {
    return new ${ClassNamePrefix}Entity(resource)
        .identifiedBy(getUri().getAbsolutePathBuilder().path(resource.getId()).build());
  }

  private List<${ClassNamePrefix}Entity> asWebEntities(
      final List<${ClassNamePrefix}> resources) {
    return resources.stream().map(this::asWebEntity).collect(SilverpeasList.collector(resources));
  }
}