package br.com.fakelibrary.data.network.mapper

import br.com.fakelibrary.data.network.models.DataResponse
import br.com.fakelibrary.data.network.models.StatusResponse
import br.com.fakelibrary.domain.Data
import br.com.fakelibrary.domain.Status

/**
 * @author RubioAlves
 * Created 02/12/2021 at 18:45
 */
fun DataResponse.toDataResponse() = Data(
    author = author,
    description = description,
    genre = genre,
    image = image,
    isbn = isbn,
    publisher = publisher,
    published = published,
    title = title
)
fun StatusResponse.toStatusResponse() = Status(
        code = code,
        data = data,
        status = status,
        total = total
)