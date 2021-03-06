package io.oneko.projectmesh.event;

import java.util.Collection;

import io.oneko.domain.DescribingEntityChange;
import io.oneko.event.EntityChangedEvent;
import io.oneko.event.EventTrigger;
import io.oneko.projectmesh.ProjectMesh;

public class ProjectMeshSavedEvent extends EntityChangedEvent {

	/**
	 * Use this constructor only with the mesh prior to actually saving it.
	 */
	public ProjectMeshSavedEvent(ProjectMesh mesh, EventTrigger trigger) {
		this(mesh, mesh.getDirtyProperties(), trigger);
	}

	public ProjectMeshSavedEvent(ProjectMesh mesh, Collection<String> changedProperties, EventTrigger trigger) {
		super(trigger, DescribingEntityChange.builder()
				.id(mesh.getId())
				.name(mesh.getName())
				.entityType(DescribingEntityChange.EntityType.ProjectMesh)
				.changeType(DescribingEntityChange.ChangeType.Saved)
				.changedProperties(changedProperties)
				.build());
	}
}
