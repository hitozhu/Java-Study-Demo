// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.htzhu.protobuf.student;

/**
 * Protobuf type {@code com.htzhu.protobuf.student.MyResponse}
 */
public final class MyResponse extends
		com.google.protobuf.GeneratedMessageV3 implements
		// @@protoc_insertion_point(message_implements:com.htzhu.protobuf.student.MyResponse)
		MyResponseOrBuilder {

	private static final long serialVersionUID = 0L;

	// Use MyResponse.newBuilder() to construct.
	private MyResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
		super(builder);
	}

	private MyResponse() {
		realname_ = "";
	}

	@java.lang.Override
	public final com.google.protobuf.UnknownFieldSet
	getUnknownFields() {
		return this.unknownFields;
	}

	private MyResponse(
			com.google.protobuf.CodedInputStream input,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws com.google.protobuf.InvalidProtocolBufferException {
		this();
		if (extensionRegistry == null) {
			throw new java.lang.NullPointerException();
		}
		int mutable_bitField0_ = 0;
		com.google.protobuf.UnknownFieldSet.Builder unknownFields =
				com.google.protobuf.UnknownFieldSet.newBuilder();
		try {
			boolean done = false;
			while (!done) {
				int tag = input.readTag();
				switch (tag) {
					case 0:
						done = true;
						break;
					default: {
						if (!parseUnknownFieldProto3(
								input, unknownFields, extensionRegistry, tag)) {
							done = true;
						}
						break;
					}
					case 18: {
						java.lang.String s = input.readStringRequireUtf8();

						realname_ = s;
						break;
					}
				}
			}
		} catch (com.google.protobuf.InvalidProtocolBufferException e) {
			throw e.setUnfinishedMessage(this);
		} catch (java.io.IOException e) {
			throw new com.google.protobuf.InvalidProtocolBufferException(
					e).setUnfinishedMessage(this);
		} finally {
			this.unknownFields = unknownFields.build();
			makeExtensionsImmutable();
		}
	}

	public static final com.google.protobuf.Descriptors.Descriptor
	getDescriptor() {
		return com.htzhu.protobuf.student.StudentProto.internal_static_com_htzhu_protobuf_student_MyResponse_descriptor;
	}

	protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
	internalGetFieldAccessorTable() {
		return com.htzhu.protobuf.student.StudentProto.internal_static_com_htzhu_protobuf_student_MyResponse_fieldAccessorTable
				.ensureFieldAccessorsInitialized(
						com.htzhu.protobuf.student.MyResponse.class,
						com.htzhu.protobuf.student.MyResponse.Builder.class);
	}

	public static final int REALNAME_FIELD_NUMBER = 2;
	private volatile java.lang.Object realname_;

	/**
	 * <code>string realname = 2;</code>
	 */
	public java.lang.String getRealname() {
		java.lang.Object ref = realname_;
		if (ref instanceof java.lang.String) {
			return (java.lang.String) ref;
		} else {
			com.google.protobuf.ByteString bs =
					(com.google.protobuf.ByteString) ref;
			java.lang.String s = bs.toStringUtf8();
			realname_ = s;
			return s;
		}
	}

	/**
	 * <code>string realname = 2;</code>
	 */
	public com.google.protobuf.ByteString
	getRealnameBytes() {
		java.lang.Object ref = realname_;
		if (ref instanceof java.lang.String) {
			com.google.protobuf.ByteString b =
					com.google.protobuf.ByteString.copyFromUtf8(
							(java.lang.String) ref);
			realname_ = b;
			return b;
		} else {
			return (com.google.protobuf.ByteString) ref;
		}
	}

	private byte memoizedIsInitialized = -1;

	public final boolean isInitialized() {
		byte isInitialized = memoizedIsInitialized;
		if (isInitialized == 1) {
			return true;
		}
		if (isInitialized == 0) {
			return false;
		}

		memoizedIsInitialized = 1;
		return true;
	}

	public void writeTo(com.google.protobuf.CodedOutputStream output)
			throws java.io.IOException {
		if (!getRealnameBytes().isEmpty()) {
			com.google.protobuf.GeneratedMessageV3.writeString(output, 2, realname_);
		}
		unknownFields.writeTo(output);
	}

	public int getSerializedSize() {
		int size = memoizedSize;
		if (size != -1) {
			return size;
		}

		size = 0;
		if (!getRealnameBytes().isEmpty()) {
			size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, realname_);
		}
		size += unknownFields.getSerializedSize();
		memoizedSize = size;
		return size;
	}

	@java.lang.Override
	public boolean equals(final java.lang.Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof com.htzhu.protobuf.student.MyResponse)) {
			return super.equals(obj);
		}
		com.htzhu.protobuf.student.MyResponse other = (com.htzhu.protobuf.student.MyResponse) obj;

		boolean result = true;
		result = result && getRealname()
				.equals(other.getRealname());
		result = result && unknownFields.equals(other.unknownFields);
		return result;
	}

	@java.lang.Override
	public int hashCode() {
		if (memoizedHashCode != 0) {
			return memoizedHashCode;
		}
		int hash = 41;
		hash = (19 * hash) + getDescriptor().hashCode();
		hash = (37 * hash) + REALNAME_FIELD_NUMBER;
		hash = (53 * hash) + getRealname().hashCode();
		hash = (29 * hash) + unknownFields.hashCode();
		memoizedHashCode = hash;
		return hash;
	}

	public static com.htzhu.protobuf.student.MyResponse parseFrom(
			java.nio.ByteBuffer data)
			throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data);
	}

	public static com.htzhu.protobuf.student.MyResponse parseFrom(
			java.nio.ByteBuffer data,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data, extensionRegistry);
	}

	public static com.htzhu.protobuf.student.MyResponse parseFrom(
			com.google.protobuf.ByteString data)
			throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data);
	}

	public static com.htzhu.protobuf.student.MyResponse parseFrom(
			com.google.protobuf.ByteString data,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data, extensionRegistry);
	}

	public static com.htzhu.protobuf.student.MyResponse parseFrom(byte[] data)
			throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data);
	}

	public static com.htzhu.protobuf.student.MyResponse parseFrom(
			byte[] data,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data, extensionRegistry);
	}

	public static com.htzhu.protobuf.student.MyResponse parseFrom(java.io.InputStream input)
			throws java.io.IOException {
		return com.google.protobuf.GeneratedMessageV3
				.parseWithIOException(PARSER, input);
	}

	public static com.htzhu.protobuf.student.MyResponse parseFrom(
			java.io.InputStream input,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws java.io.IOException {
		return com.google.protobuf.GeneratedMessageV3
				.parseWithIOException(PARSER, input, extensionRegistry);
	}

	public static com.htzhu.protobuf.student.MyResponse parseDelimitedFrom(
			java.io.InputStream input)
			throws java.io.IOException {
		return com.google.protobuf.GeneratedMessageV3
				.parseDelimitedWithIOException(PARSER, input);
	}

	public static com.htzhu.protobuf.student.MyResponse parseDelimitedFrom(
			java.io.InputStream input,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws java.io.IOException {
		return com.google.protobuf.GeneratedMessageV3
				.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
	}

	public static com.htzhu.protobuf.student.MyResponse parseFrom(
			com.google.protobuf.CodedInputStream input)
			throws java.io.IOException {
		return com.google.protobuf.GeneratedMessageV3
				.parseWithIOException(PARSER, input);
	}

	public static com.htzhu.protobuf.student.MyResponse parseFrom(
			com.google.protobuf.CodedInputStream input,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws java.io.IOException {
		return com.google.protobuf.GeneratedMessageV3
				.parseWithIOException(PARSER, input, extensionRegistry);
	}

	public Builder newBuilderForType() {
		return newBuilder();
	}

	public static Builder newBuilder() {
		return DEFAULT_INSTANCE.toBuilder();
	}

	public static Builder newBuilder(com.htzhu.protobuf.student.MyResponse prototype) {
		return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
	}

	public Builder toBuilder() {
		return this == DEFAULT_INSTANCE
				? new Builder() : new Builder().mergeFrom(this);
	}

	@java.lang.Override
	protected Builder newBuilderForType(
			com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
		Builder builder = new Builder(parent);
		return builder;
	}

	/**
	 * Protobuf type {@code com.htzhu.protobuf.student.MyResponse}
	 */
	public static final class Builder extends
			com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
			// @@protoc_insertion_point(builder_implements:com.htzhu.protobuf.student.MyResponse)
			com.htzhu.protobuf.student.MyResponseOrBuilder {

		public static final com.google.protobuf.Descriptors.Descriptor
		getDescriptor() {
			return com.htzhu.protobuf.student.StudentProto.internal_static_com_htzhu_protobuf_student_MyResponse_descriptor;
		}

		protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
		internalGetFieldAccessorTable() {
			return com.htzhu.protobuf.student.StudentProto.internal_static_com_htzhu_protobuf_student_MyResponse_fieldAccessorTable
					.ensureFieldAccessorsInitialized(
							com.htzhu.protobuf.student.MyResponse.class,
							com.htzhu.protobuf.student.MyResponse.Builder.class);
		}

		// Construct using com.htzhu.protobuf.student.MyResponse.newBuilder()
		private Builder() {
			maybeForceBuilderInitialization();
		}

		private Builder(
				com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
			super(parent);
			maybeForceBuilderInitialization();
		}

		private void maybeForceBuilderInitialization() {
			if (com.google.protobuf.GeneratedMessageV3
					.alwaysUseFieldBuilders) {
			}
		}

		public Builder clear() {
			super.clear();
			realname_ = "";

			return this;
		}

		public com.google.protobuf.Descriptors.Descriptor
		getDescriptorForType() {
			return com.htzhu.protobuf.student.StudentProto.internal_static_com_htzhu_protobuf_student_MyResponse_descriptor;
		}

		public com.htzhu.protobuf.student.MyResponse getDefaultInstanceForType() {
			return com.htzhu.protobuf.student.MyResponse.getDefaultInstance();
		}

		public com.htzhu.protobuf.student.MyResponse build() {
			com.htzhu.protobuf.student.MyResponse result = buildPartial();
			if (!result.isInitialized()) {
				throw newUninitializedMessageException(result);
			}
			return result;
		}

		public com.htzhu.protobuf.student.MyResponse buildPartial() {
			com.htzhu.protobuf.student.MyResponse result = new com.htzhu.protobuf.student.MyResponse(
					this);
			result.realname_ = realname_;
			onBuilt();
			return result;
		}

		public Builder clone() {
			return (Builder) super.clone();
		}

		public Builder setField(
				com.google.protobuf.Descriptors.FieldDescriptor field,
				java.lang.Object value) {
			return (Builder) super.setField(field, value);
		}

		public Builder clearField(
				com.google.protobuf.Descriptors.FieldDescriptor field) {
			return (Builder) super.clearField(field);
		}

		public Builder clearOneof(
				com.google.protobuf.Descriptors.OneofDescriptor oneof) {
			return (Builder) super.clearOneof(oneof);
		}

		public Builder setRepeatedField(
				com.google.protobuf.Descriptors.FieldDescriptor field,
				int index, java.lang.Object value) {
			return (Builder) super.setRepeatedField(field, index, value);
		}

		public Builder addRepeatedField(
				com.google.protobuf.Descriptors.FieldDescriptor field,
				java.lang.Object value) {
			return (Builder) super.addRepeatedField(field, value);
		}

		public Builder mergeFrom(com.google.protobuf.Message other) {
			if (other instanceof com.htzhu.protobuf.student.MyResponse) {
				return mergeFrom((com.htzhu.protobuf.student.MyResponse) other);
			} else {
				super.mergeFrom(other);
				return this;
			}
		}

		public Builder mergeFrom(com.htzhu.protobuf.student.MyResponse other) {
			if (other == com.htzhu.protobuf.student.MyResponse.getDefaultInstance()) {
				return this;
			}
			if (!other.getRealname().isEmpty()) {
				realname_ = other.realname_;
				onChanged();
			}
			this.mergeUnknownFields(other.unknownFields);
			onChanged();
			return this;
		}

		public final boolean isInitialized() {
			return true;
		}

		public Builder mergeFrom(
				com.google.protobuf.CodedInputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws java.io.IOException {
			com.htzhu.protobuf.student.MyResponse parsedMessage = null;
			try {
				parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
			} catch (com.google.protobuf.InvalidProtocolBufferException e) {
				parsedMessage = (com.htzhu.protobuf.student.MyResponse) e.getUnfinishedMessage();
				throw e.unwrapIOException();
			} finally {
				if (parsedMessage != null) {
					mergeFrom(parsedMessage);
				}
			}
			return this;
		}

		private java.lang.Object realname_ = "";

		/**
		 * <code>string realname = 2;</code>
		 */
		public java.lang.String getRealname() {
			java.lang.Object ref = realname_;
			if (!(ref instanceof java.lang.String)) {
				com.google.protobuf.ByteString bs =
						(com.google.protobuf.ByteString) ref;
				java.lang.String s = bs.toStringUtf8();
				realname_ = s;
				return s;
			} else {
				return (java.lang.String) ref;
			}
		}

		/**
		 * <code>string realname = 2;</code>
		 */
		public com.google.protobuf.ByteString
		getRealnameBytes() {
			java.lang.Object ref = realname_;
			if (ref instanceof String) {
				com.google.protobuf.ByteString b =
						com.google.protobuf.ByteString.copyFromUtf8(
								(java.lang.String) ref);
				realname_ = b;
				return b;
			} else {
				return (com.google.protobuf.ByteString) ref;
			}
		}

		/**
		 * <code>string realname = 2;</code>
		 */
		public Builder setRealname(
				java.lang.String value) {
			if (value == null) {
				throw new NullPointerException();
			}

			realname_ = value;
			onChanged();
			return this;
		}

		/**
		 * <code>string realname = 2;</code>
		 */
		public Builder clearRealname() {

			realname_ = getDefaultInstance().getRealname();
			onChanged();
			return this;
		}

		/**
		 * <code>string realname = 2;</code>
		 */
		public Builder setRealnameBytes(
				com.google.protobuf.ByteString value) {
			if (value == null) {
				throw new NullPointerException();
			}
			checkByteStringIsUtf8(value);

			realname_ = value;
			onChanged();
			return this;
		}

		public final Builder setUnknownFields(
				final com.google.protobuf.UnknownFieldSet unknownFields) {
			return super.setUnknownFieldsProto3(unknownFields);
		}

		public final Builder mergeUnknownFields(
				final com.google.protobuf.UnknownFieldSet unknownFields) {
			return super.mergeUnknownFields(unknownFields);
		}

		// @@protoc_insertion_point(builder_scope:com.htzhu.protobuf.student.MyResponse)
	}

	// @@protoc_insertion_point(class_scope:com.htzhu.protobuf.student.MyResponse)
	private static final com.htzhu.protobuf.student.MyResponse DEFAULT_INSTANCE;

	static {
		DEFAULT_INSTANCE = new com.htzhu.protobuf.student.MyResponse();
	}

	public static com.htzhu.protobuf.student.MyResponse getDefaultInstance() {
		return DEFAULT_INSTANCE;
	}

	private static final com.google.protobuf.Parser<MyResponse>
			PARSER = new com.google.protobuf.AbstractParser<MyResponse>() {
		public MyResponse parsePartialFrom(
				com.google.protobuf.CodedInputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return new MyResponse(input, extensionRegistry);
		}
	};

	public static com.google.protobuf.Parser<MyResponse> parser() {
		return PARSER;
	}

	@java.lang.Override
	public com.google.protobuf.Parser<MyResponse> getParserForType() {
		return PARSER;
	}

	public com.htzhu.protobuf.student.MyResponse getDefaultInstanceForType() {
		return DEFAULT_INSTANCE;
	}

}
