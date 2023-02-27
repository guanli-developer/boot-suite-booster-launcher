package ${basePackage}.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;
import tech.guanli.boot.internal.model.Returnable;
import ${basePackage}.core.BasicCoreController;
import ${basePackage}.model.payload.${name}Parameter;
import ${basePackage}.model.payload.${name}Payload;
import ${basePackage}.model.persistable.${name}Persistable;
import ${basePackage}.model.returnable.${name}Returnable;

@RestController
@RequestMapping("/${path}")
@Validated
public class ${name}Controller
		extends BasicCoreController<${name}Payload, ${name}Parameter, ${name}Returnable, ${idType}, ${name}Persistable> {

	@PostMapping("")
	public Returnable create(@Validated @RequestBody ${name}Payload payload) {
		return super.defaultCreate(payload);
	}

	@DeleteMapping("/{id}")
	public Returnable delete(@NotNull(message = "id is null") @PathVariable("id") ${idType} id) {
		return super.defaultDelete(id);
	}

	@PutMapping("/{id}")
	public Returnable update(@NotNull(message = "id is null") @PathVariable("id") ${idType} id,
			@RequestBody ${name}Payload payload) {
		return super.defaultUpdate(id, payload);
	}

	@GetMapping("/list/{pageNumber}/{pageSize}")
	public Returnable list(@NotNull(message = "pageNumber is null") @PathVariable("pageNumber") Integer pageNumber,
			@NotNull(message = "pageSize is null") @PathVariable("pageSize") Integer pageSize,
			${name}Parameter parameter) {
		return super.defaultList(pageNumber, pageSize, parameter);
	}

	@GetMapping("/details/{id}")
	public Returnable details(@NotNull(message = "id is null") @PathVariable("id") ${idType} id) {
		return super.defaultDetails(id);
	}

}
