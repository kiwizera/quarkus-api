package org.api.resource;

import java.util.List;

import org.api.entity.Transaction;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/transactions")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransactionResource {
    
    @GET
    public List<Transaction> listAll() {
        return Transaction.listAll();
    }
    
    @GET
    @Path("/{transactionTypeId}")
    public List<Transaction> findById(@PathParam("transactionTypeId") Long transactionTypeId) {
        List<Transaction> transactions = Transaction.findByTransactionTypeId(transactionTypeId);
        if (transactions == null) {
            throw new NotFoundException("Transação não encontrada com o transactionTypeId: " + transactionTypeId);
        }
        return transactions;
    }

    @POST
    @Transactional
    public Response create(Transaction transaction) {
        transaction.persist();
        if (transaction.transactionId != null) {
            return Response.status(Response.Status.CREATED).entity(transaction).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar a transação").build();
        }
    }

    @PUT
    @Path("/{transactionId}")
    public Transaction update(@PathParam("transactionId") Long transactionId, Transaction transaction) {
        Transaction entity = Transaction.findById(transactionId);
        if (entity == null) {
            throw new NotFoundException("Transação não encontrada com o transactionId: " + transactionId);
        }

        entity.name = transaction.name;
        entity.transactionTypeId = transaction.transactionTypeId;
        entity.transactionDate = transaction.transactionDate;
        entity.amount = transaction.amount;
        entity.category = transaction.category;

        return entity;
    }

    @DELETE
    @Transactional
    @Path("/{transactionId}")
    public Response delete(@PathParam("transactionId") Long transactionId) {
        boolean deleted = Transaction.deleteById(transactionId);
        if (deleted) {
            return Response.noContent().build();
        }
        throw new NotFoundException("Transação não encontrada com o transactionId: " + transactionId);
    }
}