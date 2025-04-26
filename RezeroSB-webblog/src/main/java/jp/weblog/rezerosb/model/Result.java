package jp.weblog.rezerosb.model;


//レスポンス結果を統一する

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code;//処理結果  0-成功  1-失敗
    private String message;//メッセージ
    private T data;//レスポンスデータ

    //レスポンス処理
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作完了", data);
    }

    //処理が成功した場合にレスポンスを返す
    public static Result success() {
        return new Result(0, "操作完了", null);
    }

    public static Result error(String message) {
        return new Result(1, message, null);
    }
}
