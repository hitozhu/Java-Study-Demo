package com.htzhu.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Message
 *
 * @author zhuhaitao
 * @date 2018/6/12 15:41
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {

	private Integer id;
	private String msg;

}
