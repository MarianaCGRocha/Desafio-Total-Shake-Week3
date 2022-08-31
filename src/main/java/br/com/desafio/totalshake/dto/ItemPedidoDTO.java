package br.com.desafio.totalshake.dto;

import br.com.desafio.totalshake.models.ItemPedido;
import br.com.desafio.totalshake.models.Pedido;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@JsonPropertyOrder({"id", "descricao", "quantidade"})
public class ItemPedidoDTO {

    @NotNull
    private Pedido pedido;
    private Long idItemPedido;
    @NotEmpty
    private String descricao;
    @NotNull
    private Integer quantidade;

    public ItemPedidoDTO(Pedido pedido, String descricao, Integer quantidade) {
        this.pedido = pedido;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public ItemPedidoDTO(Pedido pedido, Long idItemPedido, String descricao, Integer quantidade) {
        this.pedido = pedido;
        this.idItemPedido = idItemPedido;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public static ItemPedidoDTO of(ItemPedido itemPedido) {
        ItemPedidoDTO dto = new ItemPedidoDTO(
                itemPedido.getPedido(),
                itemPedido.getId(),
                itemPedido.getDescricao(),
                itemPedido.getQuantidade()
        );
        return dto;
    }
}
