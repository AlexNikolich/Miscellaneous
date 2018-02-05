package com.alex.liman.convertor;

import org.springframework.core.convert.converter.Converter;

import com.alex.liman.entity.RoomEntity;
import com.alex.liman.model.Links;
import com.alex.liman.model.Self;
import com.alex.liman.model.response.ReservationResponse;
import com.alex.liman.rest.ResourceConstants;

public class RoomEntityToReservationResponseConverter implements Converter<RoomEntity, ReservationResponse> {

	@Override
	public ReservationResponse convert(RoomEntity source) {

		ReservationResponse reservationResponse = new ReservationResponse();
		reservationResponse.setRoomNumber(source.getRoomNumber());
		reservationResponse.setPrice(Integer.valueOf(source.getPrice()));
		
		Links links = new Links();
		Self self = new Self();
		self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
		links.setSelf(self);
		
		reservationResponse.setLinks(links);
		
		return reservationResponse;
	}

}
