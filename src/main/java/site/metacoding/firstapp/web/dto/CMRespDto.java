package site.metacoding.firstapp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CMRespDto<T> {
	private Integer code;
	private String msg;
	private T data;
}
