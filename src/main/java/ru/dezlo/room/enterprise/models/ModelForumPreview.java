package ru.dezlo.room.enterprise.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "forum_preview")
public class ModelForumPreview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Formula("(select h.hash_tag from hash_tags h where h.id = id)")
	private String hashTagName;

	@Column(name = "title")
	private String title;

	@Column(name = "link")
	private String link;

	@Formula("(select now()::timestamp - max(v.date_created)::timestamp from forum_article v WHERE v.hash_tag_id = id)")
	private String lastDateUpdateArticles;

	@Formula("(select count(*) from forum_article v where v.hash_tag_id = id)")
	private Integer numberOfArticles;

}
