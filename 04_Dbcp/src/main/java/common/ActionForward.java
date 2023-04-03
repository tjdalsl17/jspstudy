package common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class ActionForward {
	private String path;	// 이동할 Jsp 경로
	private boolean isRedirect;	// 이동 방식(true이면 redirect, false이면 forward)

}
