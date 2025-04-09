package org.api.resource;

import java.util.List;

import org.api.entity.BankAccount;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/bank-accounts")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BankAccountResource {

    @GET
    public List<BankAccount> listAll() {
        return BankAccount.listAll();
    }

    @GET
    @Path("/{bankAccountId}")
    public BankAccount findById(@PathParam("bankAccountId") Long bankAccountId) {
        BankAccount bankAccount = BankAccount.findById(bankAccountId);
        if (bankAccount == null) {
            throw new NotFoundException("Conta bancária não encontrada com o ID: " + bankAccountId);
        }
        return bankAccount;
    }

    @POST
    @Transactional
    public Response create(BankAccount bankAccount) {
        bankAccount.persist();
        if (bankAccount.bankAccountId != null) {
            return Response.status(Response.Status.CREATED).entity(bankAccount).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar a conta bancária").build();
        }
    }

    @PUT
    @Path("/{bankAccountId}")
    public BankAccount update(@PathParam("bankAccountId") Long bankAccountId, BankAccount bankAccount) {
        BankAccount entity = BankAccount.findById(bankAccountId);
        if (entity == null) {
            throw new NotFoundException("Conta bancária não encontrada com o ID: " + bankAccountId);
        }

        entity.name = bankAccount.name;
        entity.accountNumber = bankAccount.accountNumber;
        entity.agencyNumber = bankAccount.agencyNumber;

        return entity;
    }

    @DELETE
    @Path("/{bankAccountId}")
    @Transactional
    public Response delete(@PathParam("bankAccountId") Long bankAccountId) {
        boolean deleted = BankAccount.deleteById(bankAccountId);
        if (deleted) {
            return Response.noContent().build();
        }
        throw new NotFoundException("Conta bancária não encontrada com o ID: " + bankAccountId);
    }
}
