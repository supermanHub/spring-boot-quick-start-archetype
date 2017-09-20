#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.assembler;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.util.CollectionUtils;
import ${package}.api.AuthorController;
import ${package}.api.BookController;
import ${package}.api.resource.AuthorResource;
import ${package}.web.entity.Author;
import ${package}.web.entity.BookAuthor;

/**
 * <b>Author Resource Assembler</b><br>
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */
public class AuthorResourceAssembler extends ResourceAssemblerSupport<Author, AuthorResource> {

	public AuthorResourceAssembler() {
		super(AuthorController.class, AuthorResource.class);
	}

	@Override
	public AuthorResource toResource(Author author) {
		AuthorResource resource = createResourceWithId(author.getId(), author);

		// books
		if (!CollectionUtils.isEmpty(author.getAuthorBooks())) {
			for (BookAuthor bookAuthor : author.getAuthorBooks()) {
				resource.add(ControllerLinkBuilder.linkTo(
						ControllerLinkBuilder.methodOn(BookController.class).getBook(bookAuthor.getBook().getId()))
						.withRel("books"));
			}
		}

		// assign book
		Link assignBookLink = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(AuthorController.class).assignBook(author.getId(), null))
				.withRel("assignBook");
		resource.add(assignBookLink);

		return resource;
	}

	@Override
	protected AuthorResource instantiateResource(Author author) {

		AuthorResource resource = new AuthorResource();
		resource.setAuthorName(author.getAuthorName());
		resource.setCreateBy(author.getCreateBy().getUsername());
		resource.setCreateDate(author.getCreateDate());
		if (null != author.getLastModifiedBy()) {
			resource.setLastModifiedBy(author.getLastModifiedBy().getUsername());
			resource.setLastModifiedDate(author.getLastModifiedDate());
		}

		return resource;
	}

}
