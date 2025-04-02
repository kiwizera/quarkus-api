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
    @Path("/{id}")
    public Transaction findById(@PathParam("id") Long id) {
        Transaction transaction = Transaction.findById(id);
        if (transaction == null) {
            throw new NotFoundException("Transação não encontrada com o ID: " + id);
        }
        return transaction;
    }

    @POST
    @Transactional
    public Response create(Transaction transaction) {
        return Response.status(Response.Status.CREATED).entity(transaction).build();
    }

    @PUT
    @Path("/{id}")
    public Transaction update(@PathParam("id") Long id, Transaction transaction) {
        Transaction entity = Transaction.findById(id);
        if (entity == null) {
            throw new NotFoundException("Transação não encontrada com o ID: " + id);
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
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = Transaction.deleteById(id);
        if (deleted) {
            return Response.noContent().build();
        }
        throw new NotFoundException("Transação não encontrada com o ID: " + id);
    }
}