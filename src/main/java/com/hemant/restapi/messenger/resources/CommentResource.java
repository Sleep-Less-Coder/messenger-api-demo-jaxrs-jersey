package com.hemant.restapi.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hemant.restapi.messenger.model.Comment;
import com.hemant.restapi.messenger.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	CommentService commentService = new CommentService();
	
	//get all the comments
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return commentService.getAllComments(messageId);
	}
	
	//get a single comment
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return commentService.getComment(messageId, commentId);
	}
	
	//add a comment
	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		commentService.addComment(messageId, comment);
		return comment;
	}
	
	//update a comment
	@PUT 
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, Comment comment) {
		commentService.updateComment(messageId, comment);
		return comment;
	}
	
	//delete a comment
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long messageId,
			@PathParam("commentId") long commentId ) {
		commentService.removeComment(messageId, commentId);
	}
}
