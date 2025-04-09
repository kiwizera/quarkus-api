package org.api.resource;

import java.util.List;

import org.api.entity.TransactionType;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/transaction-types")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransactionTypeResource {

    @GET
    public List<TransactionType> listAll() {
        return TransactionType.listAll();
    }

    @GET
    @Path("/{transactionTypeId}")
    public TransactionType findById(@PathParam("transactionTypeId") Long transactionTypeId) {
        TransactionType transactionType = TransactionType.findById(transactionTypeId);
        if (transactionType == null) {
            throw new NotFoundException("Tipo de transação não encontrado com o transactionTypeId: " + transactionTypeId);
        }
        return transactionType;
    }

    @POST
    @Transactional
    public TransactionType create(TransactionType transactionType) {
        transactionType.persist();
        if (transactionType.transactionTypeId != null) {
            return transactionType;
        } else {
            throw new InternalServerErrorException("Erro ao criar o tipo de transação");
        }
    }

    @PUT
    @Path("/{transactionTypeId}")
    public TransactionType update(@PathParam("transactionTypeId") Long transactionTypeId, TransactionType transactionType) {
        TransactionType entity = TransactionType.findById(transactionTypeId);
        if (entity == null) {
            throw new NotFoundException("Tipo de transação não encontrado com o transactionTypeId: " + transactionTypeId);
        }

        entity.name = transactionType.name;

        return entity;
    }

    @DELETE
    @Path("/{transactionTypeId}")
    @Transactional
    public Response delete(@PathParam("transactionTypeId") Long transactionTypeId) {
        boolean deleted = TransactionType.deleteById(transactionTypeId);
        if (deleted) {
            return Response.noContent().build();
        }
        throw new NotFoundException("Tipo de transação não encontrado com o transactionTypeId: " + transactionTypeId);
    }
}
